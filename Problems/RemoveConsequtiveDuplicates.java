package Problems;
// Leetcode 1047.
import java.util.Scanner;
import java.util.Stack;

public class RemoveConsequtiveDuplicates {
    static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && ch==st.peek()) 
                st.pop();
            else 
                st.push(ch);
        }

        StringBuilder str = new StringBuilder();
        while (!st.isEmpty()) {
            str.append(st.pop());
        }

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.next();
        String ans = removeDuplicates(str);
        System.out.println("String after removing consequtive chars: "+ans);
        sc.close();
    }
}
