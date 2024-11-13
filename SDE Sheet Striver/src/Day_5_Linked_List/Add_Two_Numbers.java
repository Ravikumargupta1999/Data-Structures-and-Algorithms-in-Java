package Day_5_Linked_List;

public class Add_Two_Numbers {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();

        ListNode temp = dummy;

        int carry = 0;
        while (l1 != null || l2 != null  || carry != 0) {

            int a = l1 == null ? 0 : l1.val;
            l1 = l1 == null ? null : l1.next;

            int b = l2 == null ? 0 : l2.val;
            l2 = l2 == null ? null : l2.next;

            int c = a + b + carry;

            temp.next = new ListNode(c % 10);
            temp = temp.next;
            carry = c / 10;
        }
        return dummy.next;
    }
}
