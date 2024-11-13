import java.util.HashSet;

public class Intersection_of_Two_Linked_Lists_GfG {

    static class Node {
        int data;
        Node next;

        Node(int a) {
            data = a;
            next = null;
        }
    }
    //https://practice.geeksforgeeks.org/problems/intersection-of-two-linked-list/1#
    public static Node findIntersection(Node headB, Node headA) {
        HashSet<Integer> set = new HashSet<>();
        if (headA == null || headB == null)
            return null;
        set.add(headA.data);
        headA = headA.next;
        while (headA != null) {
            set.add(headA.data);
            headA = headA.next;
        }
        Node res = new Node(-1);
        Node prev = res;

        while (headB != null) {
            if (set.contains(headB.data)) {
                prev.next = new Node(headB.data);
                prev = prev.next;
            }
            headB = headB.next;
        }
        return res.next;
    }

    public static void main(String[] args) {

    }
}
