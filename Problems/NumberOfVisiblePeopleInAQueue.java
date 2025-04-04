package Problems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue {
    static int[] canSeePersonsCount(int[] height) {
        int n = height.length;
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && height[st.peek()]<=height[i]) {
                arr[st.peek()]++;
                st.pop();
            }

            if (!st.isEmpty()) arr[st.peek()]++;
            st.push(i); 
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of Queue: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.print("Enter the heights of people in Queue: ");
        for (int i=0; i<n; i++) {
            height[i] = sc.nextInt();
        }

        int[] views = canSeePersonsCount(height);

        System.out.print(Arrays.toString(views));

        sc.close();
    }
}
