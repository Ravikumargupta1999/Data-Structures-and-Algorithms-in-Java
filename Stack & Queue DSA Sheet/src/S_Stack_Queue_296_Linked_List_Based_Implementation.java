
public class S_Stack_Queue_296_Linked_List_Based_Implementation {
    static Node head;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void push(int data) {
        Node new_node = new Node(data);
        if (head != null) {
            new_node.next = head;
        }
        head = new_node;
    }

    public static void pop() {
        if (head == null) {
            System.out.println("Stack is Empty");
        } else {
            head = head.next;
            System.out.println("Deletion Successful");
        }
    }

    public static int peek() {
        if (head == null)
            return -1;
        return head.data;
    }

    public static void traverse() {
        if (head == null) {
            System.out.println("Empty Stack");
            return;
        }
        Node temp = head;
        System.out.print("Stack Elements are : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        traverse();
        System.out.println("");
        pop();
        int value = peek();
        if (value == -1)
            System.out.println("Empty Stack");
        else
            System.out.println("Top element in stack is : " + value);
        System.out.print("\n");
        push(2);
        push(16);


        traverse();
        System.out.print("\n");
        value = peek();
        if (value == -1)
            System.out.println("Stack is Empty");
        else
            System.out.println("Top element in stack is : " + value);
        pop();
        System.out.print("\n");
        push(45);
        push(69);

        traverse();
        System.out.print("\n");
        value = peek();
        if (value == -1)
            System.out.println("Stack is Empty");
        else
            System.out.println("Top element in stack is : " + value);
        pop();
        System.out.print("\n");
        push(76);
        push(51);


        traverse();
        System.out.print("\n");
        value = peek();
        if (value == -1)
            System.out.println("Stack is Empty");
        else
            System.out.println("Top element in stack is : " + value);
        pop();
        System.out.print("\n");
        traverse();
    }
}
