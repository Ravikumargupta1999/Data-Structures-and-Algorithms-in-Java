import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Partition_a_Linked_List_around_a_given_value {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static Node partition(Node node, int x) {
        if (node == null)
            return null;
        if (node.next == null)
            return node;
        HashMap<Integer, Integer> map = new HashMap<>();

        Node res = new Node(-1);
        Node temp = res;

        Node dum = node;
        while (dum != null) {
            if (dum.data < x) {

                temp.next = new Node(dum.data);
                temp = temp.next;
            }
            dum = dum.next;
        }
        dum = node;
        while (dum != null) {
            if (dum.data < x) {

                temp.next = new Node(dum.data);
                temp = temp.next;
            }
            dum = dum.next;
        }
       dum = node;
        while (dum != null) {
            if (dum.data < x) {

                temp.next = new Node(dum.data);
                temp = temp.next;
            }
            dum = dum.next;
        }


        return res.next;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next.next.next = new Node(8);
        Node a = partition(head, 2);
        while (a != null) {
            System.out.print(a.data + " ");
            a = a.next;
        }
        System.out.println("");
    }
}
//10
//        6 5 8 6 8 10 7 1 7 8
//        2
//
//
//
//        Its Correct output is:
//
//        1 6 5 8 6 8 10 7 7 8
//
//
//
//        And Your Code's output is:
//
//        1 6 6 5 8 8 8 10 7 7