package Day1;

public class Remove_Linked_List_Elements {
    // https://leetcode.com/problems/remove-linked-list-elements/submissions/
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);

        ListNode temp = dummyNode;

        ListNode curr = head;

        while (curr != null){
            if(curr.val != val){
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
        }
        temp.next = null;
        return dummyNode.next;
    }
}
