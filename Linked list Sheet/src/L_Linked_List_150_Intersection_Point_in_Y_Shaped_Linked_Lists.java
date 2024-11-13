import java.util.HashSet;

public class L_Linked_List_150_Intersection_Point_in_Y_Shaped_Linked_Lists {
    // YT : https://www.youtube.com/watch?v=u4FWXfgS8jw
    // https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1#
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Brute Force
    // Accepted As well
    // TC : O(n)
    // SC : O(n)
    static int intersectPoint1(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (set.contains(head2))
                return head2.data;
            head2 = head2.next;
        }
        return -1;
    }

    // Optimized Solution
    // TC : O(n)
    // SC : O(n)
    int intersectPoint(Node head1, Node head2) {
        int len1 = length(head1);
        int len2 = length(head2);
        int diff = len2 > len1 ? len2 - len1 : len1 - len2;
        System.out.println(len1+"   "+len2+"   "+diff);

        if (len2 > len1) {
            len2 = len2 - diff;
        } else {
            len1 = len1 - diff;
        }

        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1 != null ? temp1.data : -1;
    }

    int length(Node head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    // Optimized Solution
    // https://www.youtube.com/watch?v=u4FWXfgS8jw
    static int intersectPoint3(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return -1;
        Node a = head1;
        Node b = head2;

        while (a != b) {
            a = a == null ? head2 : a.next;
            b = b == null ? head1 : b.next;
        }
        return a == null ? -1 : a.data;
    }

}
