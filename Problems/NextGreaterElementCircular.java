package Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class NextGreaterElementCircular {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int n = arr.length;
        for (int i=2*n-1; i>=0; i--) {
            while (!st.isEmpty() && st.peek()<=arr[i%n]) {
                st.pop();
            }
            
            if(st.isEmpty()) {
                list.add(0, -1);
            } else {
                list.add(0, st.peek());
            }
            st.push(arr[i%n]);
        }
        return list;
    }
}
