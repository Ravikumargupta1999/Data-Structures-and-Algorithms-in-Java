public class Insertion_Sort_for_Singly_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }

    }
    //https://practice.geeksforgeeks.org/problems/insertion-sort-for-singly-linked-list/0/#
    public static Node insertionSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        while (curr.next != null) {
            Node temp = curr.next;

            while (temp != null) {
                if (curr.data >= temp.data)
                    swapNodes(curr, temp);
                temp = temp.next;
            }
            curr = curr.next;
        }
        return head;
    }

    static void swapNodes(Node curr, Node temp) {
        int val = temp.data;
        temp.data = curr.data;
        curr.data = val;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(11);
        head.next.next = new Node(31);
        head.next.next.next = new Node(91);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next.next.next = new Node(9);
        printList(head);
        insertionSort(head);
        printList(head);
    }


}
