public class Linked_List_27_Remove_Duplicates_from_Sorted_List_II {
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
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-(int) 1e8);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode forw = head.next;
        int last = -(int) 1e8;
        while (forw != null) {
            ListNode temp = curr.next;
            curr.next = null;
            if (curr.val != last && curr.val != forw.val) {
                prev.next = curr;
                prev = prev.next;
            }
            last = curr.val;
            curr = temp;
            forw = forw.next;
        }
        if (curr.val != last) {
            prev.next = curr;
        }
        return dummy.next;
    }
}
