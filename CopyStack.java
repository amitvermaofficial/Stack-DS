import java.util.Scanner;
import java.util.Stack;

// Time Complexity - O(n), Space Complexity - O(n)

public class CopyStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            stack.push(sc.nextInt());
        }

        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        Stack<Integer> finalStack = new Stack<>();
        while (!tempStack.isEmpty()) {
            finalStack.push(tempStack.pop());
        }

        System.out.println(finalStack);
        sc.close();
    }
}
