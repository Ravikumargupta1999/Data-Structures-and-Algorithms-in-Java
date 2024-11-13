//https://leetcode.com/problems/reverse-linked-list/
public class Linked_List_1_Reverse_Linked_List {
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


}
