package Problems;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    static int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        int n = ast.length;
        
        for (int i=0; i<n; i++) {
            if (ast[i] > 0) {
                st.push(ast[i]);
            } else {
                while (!st.isEmpty() && st.peek()>0 && st.peek()<-ast[i]) {
                    st.pop();
                }
            }

            if (st.isEmpty() || st.peek()<0) st.push(ast[i]);
            if (st.peek() == -ast[i]) st.pop();
        }

        int sz = st.size();
        int[] res = new int[sz];
        for (int i=sz-1; i>=0; i--) {
            res[i] = st.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1, 1, 2};
        int[] res = asteroidCollision(arr);
        System.out.println(Arrays.toString(res)); 
    }
}
