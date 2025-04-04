package Problems;
import java.util.Stack;
import java.util.Scanner;

public class LargestRectangleInHistogram {
    // Brute-force
    public int largestRectangleArea1(int[] arr) {
        int max = 0;
        int n = arr.length;
        for (int i=0; i<n; i++) {
            int left = i;
            int right = i;
            while (left>=0 && arr[left] >= arr[i]) left--;
            while (right<n && arr[right] >= arr[i]) right++;
            int area = (right-left-1)*arr[i];
            max = Math.max(area, max);
        }
        return max;
    }

    // mid optimized code.
    public int largestRectangleArea2(int[] hist) {
        int n = hist.length;
        int[] lse = new int[n];
        int[] rse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && hist[st.peek()]>=hist[i])
                st.pop();
            if (st.isEmpty()) lse[i] = 0;
            else lse[i] = st.peek()+1;
            st.push(i);
        }
        while (!st.isEmpty()) st.pop();
        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && hist[st.peek()]>=hist[i]) 
                st.pop();
            if (st.isEmpty()) rse[i] = n-1;
            else rse[i] = st.peek()-1;
            st.push(i);
        }
        int max = 0;
        for (int i=0; i<n; i++) {
            int area = (rse[i]-lse[i]+1)*hist[i];
            max = Math.max(area, max);
        }
        return max;
    }

    static int largestRectangleArea(int[] hist) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while(i < hist.length){
            if(stack.isEmpty() || hist[stack.peek()] <= hist[i]){
                stack.push(i++);
            }else{
                int top = stack.pop();
                int area = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            int area = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] hist = new int[n];
        for(int i=0; i<n; i++){
            hist[i] = sc.nextInt();
        }
        System.out.println(largestRectangleArea(hist));
        sc.close();
    }
}
