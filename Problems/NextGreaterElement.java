package Problems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    static ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        list.add(-1);
        st.push(arr[n-1]);
        for (int i=n-2; i>=0; i--) {
            while (!st.isEmpty() && st.peek()<=arr[i]) 
                st.pop();
            if (st.isEmpty())
                list.add(0, -1);
            else 
                list.add(0, st.peek());
            st.push(arr[i]);
        }
        return list;
    }
    // this will give me the nextGreaterElement.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements: ");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = nextLargerElement(arr);
        System.out.print("Next Greater Element Array: ");
        System.out.println(list);

        sc.close();
    }
}
