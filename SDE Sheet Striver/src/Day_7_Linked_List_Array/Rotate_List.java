package Day_7_Linked_List_Array;

public class Rotate_List {
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
    // https://leetcode.com/problems/rotate-list/submissions/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = size(head);
        k = k % len;
        if (k == 0)
            return head;

        int n = len - k;

        ListNode curr = head;
        ListNode prev = null;
        while (n-- > 0) {
            prev = curr;
            curr = curr.next;
        }
        ListNode ans = curr;
        if (prev != null) {
            prev.next = null;
        }

        while (curr.next != null)
            curr = curr.next;
        curr.next = head;
        return ans;
    }

    public int size(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
