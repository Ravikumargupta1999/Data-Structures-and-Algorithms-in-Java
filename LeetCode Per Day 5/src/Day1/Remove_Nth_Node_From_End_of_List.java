package Day1;

import org.w3c.dom.Node;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class Remove_Nth_Node_From_End_of_List {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);
        if(n == 1){
            return reverse(head.next);
        }

        ListNode prev = null;
        ListNode curr = head;
        while (n-- > 1){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr == null ? null : curr.next;
        return reverse(head);
    }
    public ListNode reverse(ListNode node){
        if(node == null)
            return null;

        ListNode prev = null;

        ListNode curr = node;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
