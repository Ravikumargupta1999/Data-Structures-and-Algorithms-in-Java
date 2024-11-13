//https://leetcode.com/problems/reorder-list/submissions/
// https://practice.geeksforgeeks.org/problems/rearrange-linked-list-in-place/1/#
public class Linked_List_4_Fold_Of_Linked_List {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null)
            return slow;
        return slow.next;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode forw = head.next;
        ListNode prev = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode newHead = mid.next;
        mid.next = null;

        newHead = reverseList(newHead);

        ListNode c1 = head;
        ListNode c2 = newHead;

        ListNode f1 = null;
        ListNode f2 = null;
        while (c2 != null) {
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
    }

    // https://practice.geeksforgeeks.org/problems/rearrange-linked-list-in-place/1/#
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;

        }
    }

    public static Node middleNode(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null)
            return slow;
        return slow.next;

    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        Node forw = head.next;
        Node prev = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static Node rearrange(Node head) {
        Node mid = middleNode(head);
        Node nHode = mid.next;
        mid.next = null;
        nHode = reverseList(nHode);
        Node c1 = head;
        Node c2 = nHode;
        Node f1 = null;
        Node f2 = null;
        while (c2 != null) {
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
        return head;
    }
}
