public class L_Linked_List_142_Remove_A_Loop_In_A_Linked_List {
    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#
    public static void removeLoop(Node head) {
        Node meet = checkCycle(head);
        if (meet == null)
            return;
        Node start = head;

        // Edge case for start and meet are same
        if (start == meet) {
            while (start.next != meet) {
                start = start.next;
            }
            start.next = null;
            return;
        }
        Node prev = meet;
        while (start != meet) {
            start = start.next;
            prev = meet;
            meet = meet.next;
        }
        prev.next = null;
    }

    public static Node checkCycle(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return fast;
        }
        return null;
    }
}
