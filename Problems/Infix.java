package Problems;

import java.util.ArrayDeque;

public class Infix {
    public static void main(String[] args) {
        String str = "9-5+3*4/6";
        ArrayDeque<Integer> val = new ArrayDeque<>();
        ArrayDeque<Character> op = new ArrayDeque<>();

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii>=48 && ascii<=57) { // '0' -> 48 and '9'->57
                val.push(ascii-48);
            } else if (op.isEmpty()) {
                op.push(ch);
            } else {
                if (ch=='+' || ch=='-') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek()=='+') val.push(v1+v2);
                    if (op.peek()=='-') val.push(v1-v2);
                    if (op.peek()=='/') val.push(v1/v2);
                    if (op.peek()=='*') val.push(v1*v2);
                    // remove previous operand
                    op.pop();
                    // push the new operand
                    op.push(ch);
                } else if (ch=='*' || ch=='/') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (ch=='*') val.push(v1*v2);
                    if (ch=='/') val.push(v1/v2);
                }
            }
        }

        System.out.println(val.peek());
    }
}
