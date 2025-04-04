package Problems;
import java.util.Scanner;
import java.util.Stack;
// TC: O(n) and SC: O(n)
class ValidParaentheses {
    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
	// using stack figure it out.
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(')');
            } else if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            } else if (st.isEmpty() || ch != st.pop()) {
                return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of Parantheses: ");
        String s = sc.next();
        System.out.println(isValid(s));
        sc.close();
    }
}
