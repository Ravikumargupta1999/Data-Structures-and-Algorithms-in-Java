import java.util.Scanner;

public class S_Stack_Queue_316_Stack_Using_Deque {
    static Scanner sc = new Scanner(System.in);
    static Node head;
    static Node top = null;

    static class Node {
        int data;
        Node next;
        Node prev;
    }


    public static void push(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        new_node.prev = null;


        if (head == null) {
            head = new_node;
            return;
        } else {
            head.prev = new_node;
            new_node.next = head;
            head = new_node;

        }
        top = head;
    }

    public static void pop() {
        if (head == null) {
            System.out.println("Stack is Empty");
        } else {
            head = head.next;
            head.prev = null;
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
            System.out.println("Stack is Empty");
            return;
        }
        Node node = head;
        System.out.print("Forward Traversal :  ");
        while (true) {
            System.out.print(node.data + " ");
            if (node.next == null)
                break;
            node = node.next;
        }
        System.out.print("\nBackward Traversal : ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.prev;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        traverse();
        pop();
        int value = peek();
        if (value == -1)
            System.out.println("Stack is Empty");
        else
            System.out.println("Top element in stack is : " + value);
        System.out.println("");
        System.out.println("");


        push(2);
        push(16);
        traverse();
        value = peek();
        if (value == -1)
            System.out.println("Stack is Empty");
        else
            System.out.println("Top element in stack is : " + value);
        pop();
        System.out.println("");
        System.out.println("");


        push(45);
        push(69);
        traverse();
        value = peek();
        if (value == -1)
            System.out.println("Stack is Empty");
        else
            System.out.println("Top element in stack is : " + value);
        pop();
        System.out.println("");
        System.out.println("");


        push(76);
        push(51);
        traverse();
        value = peek();
        if (value == -1)
            System.out.println("Stack is Empty");
        else
            System.out.println("Top element in stack is : " + value);
        pop();
        System.out.println("");
        System.out.println("");
        traverse();
    }
}
