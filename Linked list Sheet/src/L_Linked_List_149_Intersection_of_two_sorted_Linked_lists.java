public class L_Linked_List_149_Intersection_of_two_sorted_Linked_lists {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1#
    public static Node findIntersection(Node head1, Node head2) {

        Node dummy = new Node(-1);

        Node curr = dummy;

        while (head1 != null && head2 != null) {
            // System.out.println(head1.data +"    "+head2.data);
            if(head1.data < head2.data)
                head1 = head1.next;
            else if(head2.data < head1.data)
                head2 = head2.next;
            else {

                curr.next = head1;
                curr = curr.next;

                head1 = head1.next;
                head2 = head2.next;
            }
        }
        curr.next = null;
        return dummy.next;

    }
}
