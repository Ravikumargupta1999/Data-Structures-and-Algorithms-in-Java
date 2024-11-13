public class Linked_List_13_Reverse_Linked_List_Using_Add_First {
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
    //https://leetcode.com/problems/reverse-linked-list/submissions/
    void addFirst(ListNode node)
    {
        if(th == null)
        {
            th = node;
            tt = node;
        }
        else
        {
            node.next = th;
            th = node;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        while (curr != null)
        {
            ListNode forward = curr.next;
            curr.next = null;
            addFirst(curr);
            curr = forward;
        }
        return th;
    }

}
