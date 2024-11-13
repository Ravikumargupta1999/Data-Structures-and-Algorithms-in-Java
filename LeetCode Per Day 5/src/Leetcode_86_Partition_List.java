import java.util.List;

public class Leetcode_86_Partition_List {
    // https://leetcode.com/problems/partition-list/submissions/
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


    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode temp1 = dummy1;
        ListNode temp2 = dummy2;

        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            ListNode node1 = curr;

            curr = next;
            if (node1.val < x) {
                temp1.next = node1;
                temp1 = temp1.next;
            } else {
                temp2.next = node1;
                temp2 = temp2.next;
            }
        }
        temp1.next = null;
        temp2.next = null;

        temp1.next = dummy2.next;
        return dummy1;
    }
}
