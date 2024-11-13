package Day_6_Linked_LIST_II;

public class Remove_Cycle_From_A_Linked_List {
    class Node {
        int data;
        Node next;
    }
    public static void removeLoop(Node head){
        Node meet = checkCycle(head);
        if (meet == null)
            return;
        Node start = head;
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
