public class Linked_List_5_Unfold_A_Linked_List {
    // https://www.youtube.com/watch?v=GjhGhEoZ1Vk&list=PL-Jc9J83PIiGRqcfZxxgOKovgLVd3znnq&index=5
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


    static void unFold(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode fp = head;
        ListNode Sh = head.next;
        ListNode sp = Sh;
        while (sp != null && sp.next != null) {
            ListNode f = sp.next;

            fp.next = f;
            sp.next = f.next;

            fp = fp.next;
            sp = sp.next;
        }
        fp.next = null;
        fp.next = reverseList(Sh);


    }



    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode forw = head.next;
        ListNode prev = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }


}
