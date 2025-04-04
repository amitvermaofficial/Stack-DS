package Problems;

import java.util.ArrayList;
import java.util.Stack;

public class MakeArrayBeautiful {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        ArrayList<Integer> li = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (!stack.isEmpty() && ((stack.peek()>=0 && num<0) || (stack.peek()<0 && num>=0))) {
                stack.pop(); 
            } else {
                stack.push(num);
            }
        }
        
        li.addAll(stack);
        return li;
    }
}

