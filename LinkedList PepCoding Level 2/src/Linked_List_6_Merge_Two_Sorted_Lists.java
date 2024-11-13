public class Linked_List_6_Merge_Two_Sorted_Lists {
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

    ///https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                temp.next = c1;
                c1 = c1.next;
            } else {
                temp.next = c2;
                c2 = c2.next;
            }
            temp = temp.next;
        }
        temp.next = c1 != null ? c1 : c2;
        return dummy.next;
    }
//
}
