package CodeChef;

import java.util.Scanner;

public class Remove_Duplicates {
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        int t = st.nextInt();
        while (t-- > 0) {
            int n = st.nextInt();
            Node temp = new Node(-1);
            Node node = temp;
            while (n-- > 0) {
                temp.next = new Node(st.nextInt());
                temp = temp.next;
            }

            print(listReverse(node.next));
        }
    }

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    static Node listReverse(Node head) {
        Node temp = new Node(-1);
        Node node = temp;
        while (head.next != null) {
            if (head.data != temp.data) {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return node.next;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }
}
