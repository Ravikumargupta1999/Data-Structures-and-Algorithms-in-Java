import java.util.HashSet;

public class L_Linked_List_145_Remove_Duplicates_From_UnSorted_A_Linked_List {
    static class Node
        {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
    public Node removeDuplicates(Node head) {
        if (head == null || head.next == null)
            return head;
        Node dummy = new Node(-1);
        Node temp = dummy;
        HashSet<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head.data)) {
                temp.next = head;
                temp = temp.next;
            }
            set.add(head.data);
            head = head.next;
        }
        temp.next = null;
        return dummy.next;
    }
}
