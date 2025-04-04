package Problems;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SumOfSubarrayMins {

    static int MOD = 1000000007;

    static int[] pse(int[] arr) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            // If stack is empty, no smaller element to the left
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    static int[] nse(int[] arr) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            // If stack is empty, no smaller element to the right
            res[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return res;
    }

    public static int sumSubarrayMins(int[] arr) {
        int[] pse = pse(arr);
        int[] nse = nse(arr);
        System.out.println("pse: " + Arrays.toString(pse) + "\n nse: " + Arrays.toString(nse));
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            sum += (int) ((long) left * right % MOD * arr[i] % MOD);
            sum %= MOD;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int ans = sumSubarrayMins(arr);
        System.out.println(ans); // Output: 17
    }
}



