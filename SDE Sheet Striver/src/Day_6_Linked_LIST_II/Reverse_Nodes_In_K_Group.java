package Day_6_Linked_LIST_II;

public class Reverse_Nodes_In_K_Group {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (size(head) < k)
            return head;


        ListNode curr = head;
        ListNode prev = null;
        int size = k;
        while (size-- > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(curr == null)
            return prev;
        head.next = reverseKGroup(curr.next,k);
        return prev;
    }

    public int size(ListNode node) {
        int count = 0;

        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
}
