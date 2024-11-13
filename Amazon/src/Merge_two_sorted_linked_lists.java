// https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=3&query=company[]Amazondifficulty[]1page3company[]Amazon

public class Merge_two_sorted_linked_lists {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Function to merge two sorted linked list.
    static Node sortedMerge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        else if (head2 == null)
            return head1;
        if (head1 == null && head2 == null)
            return null;
        Node head = new Node(-1);
        Node temp = head;
        Node a = head1;
        Node b = head2;
        while (head != null || head2 != null) {
            if (head1 == null) {
                temp.next = head2;
//                System.out.println(head2.data +"  "+temp.data);
                break;
            } else if (head2 == null) {
                temp.next = head1;
//                System.out.println(head1.data);
                break;
            } else if (head1.data == head2.data) {
                temp.next = new Node(head1.data);
//                System.out.println(head2.data +"  "+temp.data);
                head1 = head1.next;
            } else if (head1.data < head2.data) {
                temp.next = new Node(head1.data);
//                System.out.println(head1.data +"  "+temp.data);
                head1 = head1.next;
            } else if (head1.data > head2.data) {
                temp.next = new Node(head2.data);
//                System.out.println(head2.data +"  "+temp.data);
                head2 = head2.next;
            }
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args){
        Node head1 = new Node(5);
        head1.next = new Node(10);
//        head1.next.next = new Node(15);
//        head1.next.next.next= new Node(40);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        Node head = sortedMerge(head1,head2);
        while (head != null)
        {
            System.out.print(head.data+"  ");
            head = head.next;
        }


    }
}
