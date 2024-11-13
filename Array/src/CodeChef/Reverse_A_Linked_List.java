package CodeChef;

import java.util.Scanner;

public class Reverse_A_Linked_List {
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        int n = st.nextInt();
        Node temp = new Node(-1);
        Node node = temp;
        while (n-- > 0) {
            temp.next = new Node(st.nextInt());
            temp = temp.next;
        }

        print(listReverse(node.next));
    }
    public static void print(Node node){
        while (node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println("");
    }
    static Node listReverse(Node head)
    {
        Node current,previous,next;
        current =  head;
        previous = null;
        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next ;
        }
        head = previous;
        return head;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }
}
