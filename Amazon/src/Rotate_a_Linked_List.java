public class Rotate_a_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1/?difficulty[]=1&page=1&category[]=Linked%20List&query=difficulty[]1page1category[]Linked%20List#


    //Function to rotate a linked list.
    public static Node rotate(Node head, int k) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        int totalNodes = 0;
        Node root = head;
        while (root != null) {
            totalNodes++;
            root = root.next;
        }
        if (k == 0 || k == totalNodes)
            return head;
        int count1 = 1;
        Node temp1 = head;
        while (temp1 != null && count1 <= k) {
            temp1 = temp1.next;
            count1++;
        }
//        Node a = temp1;
//        while (a != null) {
//            System.out.print(a.data + "  ");
//            a = a.next;
//        }
//        System.out.println("");
//

        Node temp2 = head;
        int count2 = 1;
        while (temp2 != null && count2 < k) {
            temp2 = temp2.next;
            count2++;
        }
        temp2.next = null;
//        a = temp2;
//        while (a != null) {
//            System.out.print(a.data + "  ");
//            a = a.next;
//        }
//        System.out.println("");


        Node res = temp1;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = head;
//        a = temp1;
//        while (a != null) {
//            System.out.print(a.data + "  ");
//            a = a.next;
//        }
//        System.out.println("");
        return res;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
//        1, 2, 3, 4, 5, 6, 7, 8
        head = rotate(head, 8);
        Node a = head;
        while (a != null) {
            System.out.print(a.data + "  ");
            a = a.next;
        }
        System.out.println("");
    }

}

// 1, 2, 3, 4, 5, 6, 7, 8
