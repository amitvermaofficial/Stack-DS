package Problems;
import java.util.*;

public class StockSpan {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i=0; i<arr.length; i++) {
            while (!st.isEmpty() && arr[i]>=arr[st.peek()]) {
                st.pop();
            }
            
            if (st.isEmpty()) list.add(i+1);
            else list.add(i-st.peek());
            st.push(i);
        }
        return list;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockSpan obj = new StockSpan();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> list = obj.calculateSpan(arr);
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        sc.close();
    }
}
