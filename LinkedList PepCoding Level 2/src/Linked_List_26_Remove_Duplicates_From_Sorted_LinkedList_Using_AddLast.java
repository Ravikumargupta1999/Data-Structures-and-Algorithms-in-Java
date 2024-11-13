public class Linked_List_26_Remove_Duplicates_From_Sorted_LinkedList_Using_AddLast {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        while (curr != null) {
            ListNode forward = curr.next;
            curr.next = null;
            if (tt == null || tt.val != curr.val)
                addLast(curr);
            curr = forward;
        }
        return th;

    }
}
