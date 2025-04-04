package Problems;

import java.util.ArrayDeque;

public class RemoveKElements {
    
    static String removeKdigits(String s, int k) {
        if (s.length() == k) return "0"; // Edge case

        ArrayDeque<Character> st = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // Remove remaining `k` digits from the top if needed
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pollLast()); // Reverse order
        }

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }
}
