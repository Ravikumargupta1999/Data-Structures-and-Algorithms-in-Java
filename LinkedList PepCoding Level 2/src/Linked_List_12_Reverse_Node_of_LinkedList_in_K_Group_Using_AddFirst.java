public class Linked_List_12_Reverse_Node_of_LinkedList_in_K_Group_Using_AddFirst {
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

    static ListNode th = null;
    static ListNode tt = null;

    //https://leetcode.com/problems/reverse-linked-list/submissions/
    static void addFirst(ListNode node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static ListNode reverseKGroup(ListNode node, int k) {
        if (node == null || node.next == null || k == 0)
            return node;
        int length = size(node);
        ListNode curr = node;
        ListNode oh = null;
        ListNode ot = null;
        while (length >= k) {

            int c = k;
            while (c-- > 0) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            if (oh == null) {
                oh = th;
                ot = tt;
                tt = null;
                th = null;
            } else {
                ot.next = th;
                ot = tt;
                tt = null;
                th = null;

            }
            length -= k;
        }

        ot.next = curr;
        return oh;
    }

    public static int size(ListNode node) {
        ListNode temp = node;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

}
