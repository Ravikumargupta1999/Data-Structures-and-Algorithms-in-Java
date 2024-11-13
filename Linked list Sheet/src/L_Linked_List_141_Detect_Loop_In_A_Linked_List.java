import java.util.HashMap;
import java.util.HashSet;

public class L_Linked_List_141_Detect_Loop_In_A_Linked_List {
    Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://www.youtube.com/watch?v=jcZtMh_jov0
    // https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
    // 1st approach :
    // TC: O(n)
    // SC: O(n)
    public static boolean detect_loop1(Node head) {
        if (head == null)
            return false;
        HashMap<Node, Integer> hm = new HashMap<>();
        while (head != null) {
            if (hm.containsKey(head))
                return true;
            else {
                hm.put(head, 1);
                head = head.next;
            }
        }
        return false;
    }

    // 1st approach :
    // TC: O(n)
    // SC: O(n)
    public static boolean detect_loop2(Node head) {
        if (head == null)
            return false;
        HashSet<Node> hm = new HashSet<>();
        while (head != null) {
            if (hm.contains(head))
                return true;
            else {
                hm.add(head);
                head = head.next;
            }
        }
        return false;
    }


    // 2nd efficient approach :
    // TC: O(n)
    // SC: O(1)
    public static boolean detectLoop3(Node head) {

        if (head == null)
            return false;
        Node low = head;
        Node high = head;
        while (high != null && high.next != null) {
            low = low.next;
            high = high.next.next;
            if (low == high)
                return true;
        }
        return false;
    }


}
