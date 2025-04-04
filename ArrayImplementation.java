public class ArrayImplementation {
    private int[] arr = new int[10];
    private int idx = 0;

    void push(int x) throws Error {
        if (idx == arr.length) {
            throw new Error("Stack OverFlow!! Capacity fulled.");
        }
        arr[idx] = x;
        idx++;
    }

    int pop() throws Error{
        if (idx == 0) {
            throw new Error("Stack UnderFlow, No more Elements exists in Stack.");
        }

        int top = arr[idx-1];
        arr[idx-1] = 0;
        idx--;
        return top;
    }

    int peek() throws Error {
        if (idx == 0) {
            throw new Error("Stack UnderFlow, No more Elements exists in Stack.");
        }
        return arr[idx-1];
    }

    int size() {
        return idx;
    }

    void display() {
        for (int i=0; i<idx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    boolean isEmpty() {
        if (idx == 0) {
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (idx == arr.length) {
            return true;
        }
        return false;
    }

    int capacity() {
        return arr.length;
    }

    public static void main(String[] args) {
        ArrayImplementation st = new ArrayImplementation();
        st.push(1);
        st.display();
        st.push(2);
        st.display();
        st.push(3);
        st.display();
        st.push(4);
        st.display();
        st.push(5);
        st.display();
        st.push(6);
        st.display();
        System.out.println("pop: "+st.pop());
        st.display();
        st.push(7);
        st.push(8);
        st.push(9);
        st.push(10);
        st.display();
        st.push(11);
        st.display();
        System.out.println(st.isFull());
        st.push(12);
        st.display();
        
    }
}
