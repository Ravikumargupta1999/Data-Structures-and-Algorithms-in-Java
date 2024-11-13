package Day3;

public class Swap_Nodes_In_Pairs {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);

        ListNode temp = dummy;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next.next;

            ListNode first = curr;

            ListNode second = curr.next;
            curr.next = null;
            second.next = curr;
            temp.next = second;
            temp = first;

            curr = next;
        }
        if (curr != null) {
            temp.next = curr;
        }
        return dummy.next;
    }
}
