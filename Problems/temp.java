package Problems;

import java.util.*;

public class temp {
    
    static List<Integer> leftSmaller(int n, int a[]) {
        //code here
        List<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && st.peek()>=a[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                list.add(-1);
            } else {
                list.add(st.peek());
            }
            st.push(a[i]);
        }
        return list;
    }
}

