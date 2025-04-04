public class SumOfSubarrayRanges {

    // brute force method O(n^2)
    public long subArrayRanges(int[] arr) {
        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
        long sum = 0;
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            largest = arr[i];
            smallest = arr[i];
            for (int j=i+1; j<n; j++) {
                largest = Math.max(largest, arr[j]);
                smallest = Math.min(smallest, arr[j]);
                sum += (largest - smallest);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        
    }
}


class Optimal { // O(n)
    public int[] pse(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && arr[st.peek()]>arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] nse(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] pge(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && arr[st.peek()]<arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] nge(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()]<=arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] pse = pse(nums);
        int[] nse = nse(nums);

        int[] pge = pge(nums);
        int[] nge = nge(nums);

        long totalSmall = 0;
        long totalGreat = 0;
        for (int i=0; i<n; i++) {
            int leftS = i - pse[i];
            int rightS = nse[i] - i;
            long prodS = leftS * rightS;
            prodS *= nums[i];
            totalSmall += prodS;

            int leftG = i - pge[i];
            int rightG = nge[i] - i;
            long prodG = leftG * rightG;
            prodG *= nums[i];
            totalGreat += prodG;
        }

        long res = totalGreat - totalSmall;

        return res;
    }
}