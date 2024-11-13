public class Linked_List_22_Add_Two_Linked_List {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    // Its Correct but requirement is without using extra space
    // https://leetcode.com/problems/add-two-numbers/submissions/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;
        // l1 = reverse(l1);
        // l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int rem = 0;
        while (c1 != null || c2 != null || rem > 0) {
            int sum = 0;
            if (c1 != null) {
                sum = sum + c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum = sum + c2.val;
                c2 = c2.next;
            }
            prev.next = new ListNode((sum + rem) % 10);
            prev = prev.next;
            rem = (sum + rem) / 10;
        }
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode forw = null;
        ListNode curr = head;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(19 % 10);
    }
}
