import java.util.Stack;
public class Intro {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(4);
        st.push(5);
        st.push(10);
        st.push(15);
        st.push(18);
        System.out.println(st);
        System.out.println(st.pop());
        System.out.println(st);
    }
}