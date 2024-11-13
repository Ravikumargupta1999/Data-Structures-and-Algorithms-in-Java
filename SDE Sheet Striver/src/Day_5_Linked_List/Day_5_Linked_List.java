package Day_5_Linked_List;

public class Day_5_Linked_List {
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

    // https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;

            curr = next;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        return reverseList(head,null);
    }
    public ListNode reverseList(ListNode curr,ListNode prev){
        if(curr == null)
            return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseList(next,prev);
    }
}