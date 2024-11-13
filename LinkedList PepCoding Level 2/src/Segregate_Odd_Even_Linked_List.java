public class Segregate_Odd_Even_Linked_List {
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

    // https://leetcode.com/problems/odd-even-linked-list/
    // Similar to unfold a list // thoda sa difference
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode fH = head;
        ListNode sH = head.next;
        ListNode fp = fH;
        ListNode sp = sH;
        while (sp != null && sp.next != null) {
            ListNode f = sp.next;


            fp.next = f;
            sp.next = f.next;

            fp = fp.next;
            sp = sp.next;
        }
        fp.next = sH;
        return head;

    }

}
