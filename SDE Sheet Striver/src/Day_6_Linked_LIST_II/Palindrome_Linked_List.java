package Day_6_Linked_LIST_II;

public class Palindrome_Linked_List {
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

    public static boolean isPalindrome(ListNode head) {
        // wrong hoga bhaiyya
//        ListNode rev = reverse(head);
//        printList(head);
//        printList(rev);
//        while (head != null)
//        {
//            if(head.val != rev.val)
//                return false;
//            head = head.next;
//            rev = rev.next;
//        }
//        return true;

        if (head == null || head.next == null)
            return true;
        ListNode rev = reverse(middleNode(head));

        while (head != null && rev != null) {
            if (head.val != rev.val)
                return false;
            head = head.next;
            rev = rev.next;
        }
        return true;


    }

    public static ListNode middleNode(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;

    }

    public static ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(ListNode node) {
        System.out.println("\n");
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println("\n");

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(1);
        a.next.next = new ListNode(2);
//        a.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(a));
    }
}
