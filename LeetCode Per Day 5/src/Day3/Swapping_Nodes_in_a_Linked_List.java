package Day3;

public class Swapping_Nodes_in_a_Linked_List {
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

    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = getKthNode(head, k);
        ListNode second = getKthNode(head, size(head) - k + 1);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        return head;
    }

    ListNode getKthNode(ListNode head, int k) {
        ListNode curr = head;

        while (curr != null && k-- > 1) {
            curr = curr.next;
        }
        return curr;
    }

    public int size(ListNode head) {
        int l = 0;
        ListNode curr = head;

        while (curr != null) {
            l++;
            curr = curr.next;
        }
        return l;
    }
}
