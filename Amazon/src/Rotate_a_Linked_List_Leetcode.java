import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Rotate_a_Linked_List_Leetcode {
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


    // https://leetcode.com/problems/rotate-list/submissions/

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        int totalNodes = 0;
        ListNode root = head;
        while (root != null) {
            totalNodes++;
            root = root.next;
        }
//        System.out.println();
        k = k % totalNodes;
//        System.out.println(k + "  " + totalNodes);
        k = totalNodes - k;
        if (k == 0 || k == totalNodes)
            return head;
        int count1 = 1;
        ListNode temp1 = head;
        while (temp1 != null && count1 <= k) {
            temp1 = temp1.next;
            count1++;
        }

        ListNode temp2 = head;
        int count2 = 1;
        while (temp2 != null && count2 < k) {
            temp2 = temp2.next;
            count2++;
        }
        temp2.next = null;


        ListNode res = temp1;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = head;
        return res;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = rotateRight(head, 6);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println("");

    }
}
