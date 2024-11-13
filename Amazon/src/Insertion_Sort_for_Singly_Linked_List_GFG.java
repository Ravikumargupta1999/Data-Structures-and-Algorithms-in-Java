public class Insertion_Sort_for_Singly_Linked_List_GFG {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


// https://practice.geeksforgeeks.org/problems/insertion-sort-for-singly-linked-list/1/?difficulty[]=1&page=2&category[]=Linked%20List&query=difficulty[]1page2category[]Linked%20List#

    public static Node insertionSort(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        Node res = null;
        Node temp = head;
        while (temp != null) {
            if (res == null) {
                res = new Node(temp.data);
            } else if (res.data >= temp.data) {
                Node newNode = new Node(temp.data);
                newNode.next = res;
                res = newNode;
            } else {
                boolean found = false;
                Node curr = res;
                while (curr.next != null && curr.data < temp.data) {
                    if (found)
                        break;
                    if (temp.data > curr.next.data) {
                        curr = curr.next;
                        continue;

                    }
                    Node temp1 = curr.next;
                    curr.next = new Node(temp.data);
                    curr.next.next = temp1;
                    found = true;
                }
                if (!found) {

                    curr.next = new Node(temp.data);
                }
            }
//            Node a = res;
//            while (a != null) {
//                System.out.print(a.data+"  ");
//                a = a.next;
//            }
//            System.out.println("");
            temp = temp.next;
        }

        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(0);
        head.next.next = new Node(0);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(0);
        Node res = insertionSort(head);
        Node a = res;
        while (a != null) {
            System.out.print(a.data + "  ");
            a = a.next;
        }
        System.out.println("");
    }
}
