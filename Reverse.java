import java.util.Scanner;
import java.util.Stack;
public class Reverse {
    // Recursive Method
    static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) { 
            stack.push(item);
            return;
        }
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(item);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) 
            return;
        int item = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, item);
    }

    // Iterative Method
    static Stack<Integer> reverseIterative(Stack<Integer> stack) {
        Stack<Integer> revStack = new Stack<>();
        while (!stack.isEmpty()) {
            revStack.push(stack.pop());
        }
        return revStack;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        while (sc.hasNextInt()) {
            stack.push(sc.nextInt());
        }
        sc.next();
        // Stack<Integer> revStack = reverseIterative(stack);
        // System.out.println(revStack);
        
        reverseStack(stack);
        System.out.println(stack);
        sc.close();
    }
}
