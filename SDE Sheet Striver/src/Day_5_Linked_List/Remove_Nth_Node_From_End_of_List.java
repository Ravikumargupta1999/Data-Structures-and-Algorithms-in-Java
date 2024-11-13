package Day_5_Linked_List;

import java.util.List;

public class Remove_Nth_Node_From_End_of_List {
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


    // Method 1
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);

        if (n == 1) {
            return reverse(head.next);
        }
        ListNode curr = head;

        ListNode prev = null;
        while (n-- > 1) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return reverse(head);
    }

    public ListNode reverse(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        ListNode curr = node;
        ListNode prev = null;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        int len = len(head);
        n = len - n + 1;
        if (n == 1) {
            return head.next;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (n-- > 1) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;

    }

    static int len(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    static void printLIST(ListNode node) {
        System.out.println("\n");
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println("");
    }


    // Optimized
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 1; i <= n; i++)
            fast = fast.next;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
