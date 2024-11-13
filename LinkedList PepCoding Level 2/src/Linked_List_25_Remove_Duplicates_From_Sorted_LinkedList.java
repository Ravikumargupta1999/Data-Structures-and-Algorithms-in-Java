public class Linked_List_25_Remove_Duplicates_From_Sorted_LinkedList {
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

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        if (head == null || head.next == null)
            return head;
        int last = head.val;

        prev.next = new ListNode(last);
        prev = prev.next;

        ListNode temp = head.next;

        while (temp != null) {
            if (temp.val != last) {
                prev.next = new ListNode(temp.val);
                prev = prev.next;
            }
            last = temp.val;
            temp = temp.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-(int) 1e8);
        ListNode itr = dummy, curr = head;
        while (curr != null) {
            while (curr != null && itr.val == curr.val)
                curr = curr.next;
            itr.next = curr;
            itr = itr.next;
            if (curr != null)
                curr = curr.next;
        }
        return dummy.next;

    }

    ListNode tt = null;
    ListNode th = null;

    void addLast(ListNode head) {
        if (th == null) {
            tt = th = head;
        } else {
            tt.next = head;
            tt = tt.next;
        }
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = null;
            if (tt == null || tt.val != curr.val)
                addLast(curr);
            curr = forw;
        }
        return th;

    }
}
