public class Linked_List_9_Merge_Sort {

    //      Definition for singly-linked list.
    public static class ListNode {
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

    //https://leetcode.com/problems/sort-list/submissions/
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = middleNode(head);
        ListNode newHead = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(newHead);
        return mergeTwoLists(l1, l2);

    }

    public static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                temp.next = c1;
                c1 = c1.next;
            } else {
                temp.next = c2;
                c2 = c2.next;
            }
            temp = temp.next;
        }
        temp.next = c1 != null ? c1 : c2;
        return dummy.next;
    }

    static void printList(ListNode node) {
        ListNode head = node;
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(-2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-12);
        head.next.next.next = new ListNode(22);
        printList(head);
        head = sortList(head);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }

    }
}