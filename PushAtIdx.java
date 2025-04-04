import java.util.Scanner;
import java.util.Stack;

public class PushAtIdx {
    static void insert(Stack<Integer> stack, int idx, int val) throws Error {
        if (idx < 0 || idx > stack.size()) {
            throw new Error("Invalid Index");
        }
        if (idx == stack.size()) {
            stack.push(val);
            return;
        }

        Stack<Integer> tempStack = new Stack<>();
        while (stack.size()>idx) {
            tempStack.push(stack.pop());
        }
        stack.push(val);
        while (tempStack.size()>0) {
            stack.push(tempStack.pop());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        while (sc.hasNextInt()) {
            stack.push(sc.nextInt());
        }
        sc.next();
        System.out.print("Enter index and value : ");
        int idx = sc.nextInt();
        int val = sc.nextInt();

        insert(stack, idx, val);
        System.out.println(stack);
        sc.close();
    }
}
