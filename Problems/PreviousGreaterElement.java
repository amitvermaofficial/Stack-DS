package Problems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PreviousGreaterElement {
    static ArrayList<Integer> previousLargerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && st.peek()<=arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) list.add(-1);
            else list.add(st.peek());
            st.push(arr[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements: ");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = previousLargerElement(arr);
        System.out.print("Array of Previous Greater Elements: ");
        System.out.println(list);
        sc.close();
    }
}
