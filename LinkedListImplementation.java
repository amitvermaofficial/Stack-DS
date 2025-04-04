class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class LinkedListImplementation {
    private Node head;
    int size;

    void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop() throws Error {
        if (head == null) {
            throw new Error("UnderFlow Condition!!, No elements exists in Stack.");
        }
        int top = head.val;
        head = head.next;
        size--;
        return top;
    }

    int peek() throws Error {
        if (head == null)
            throw new Error("UnderFlow Condition!!, No elements exists in Stack.");
        int top = head.val;
        return top;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    boolean isEmpty() {
        if (head == null) 
            return true;
        return false;
    }

    void pushAt(int idx, int x) throws Error {
        if (size == 0 || size < idx || idx < 0) 
            throw new Error("Invalid index, Index out of bound");
        Node tempNode = new Node(x);
        size++;
        if (idx == 0) {
            tempNode.next = head;
            head = tempNode;
            return;
        }
        Node temp = head;
        for (int i=1; i<idx; i++) {
            temp = temp.next;
        }
        tempNode.next = temp.next;
        temp.next = tempNode;
    }

    public static void main(String[] args) {
        LinkedListImplementation stack = new LinkedListImplementation();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(9);
        stack.display();
        System.out.println(stack.pop());
        stack.display();
        stack.pushAt(1, 100);
        stack.display();
    }
}
