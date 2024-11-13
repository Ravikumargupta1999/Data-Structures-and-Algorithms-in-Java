public class L_Linked_List_151_Merge_Sort {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = middleElement(head);
        Node right = mid.next;
        mid.next = null;
        return mergeTwoSortedList(mergeSort(head),mergeSort(right));
    }

    static Node middleElement(Node node) {

        Node slow = node;
        Node fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node mergeTwoSortedList(Node n1, Node n2) {
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node l1 = n1;
        Node l2 = n2;

        while (n1 != null || n2 != null) {
            if (n1 != null && n2 != null) {
                if (n1.data < n2.data) {
                    curr.next = n1;
                    curr = curr.next;
                    n1 = n1.next;
                } else {
                    curr.next = n2;
                    curr = curr.next;
                    n2 = n2.next;
                }
            } else {
                if(n1 != null){
                    curr.next = n1;
                    curr = curr.next;
                    n1 = n1.next;
                }else {
                    curr.next = n2;
                    curr = curr.next;
                    n2 = n2.next;
                }
            }
        }
        curr.next = null;
        return dummy.next;
    }
}
