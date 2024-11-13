public class L_Linked_List_152_Quick_Sort_On_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node quickSort(Node head) {
        return quickSort_(head)[0];
    }

    static Node[] quickSort_(Node head) {
        if (head == null || head.next == null)
            return new Node[]{head, head};
        int length = length(head);
        int pivotIdx = length / 2;
        Node[] segregateList = segreate(head, pivotIdx);
        Node[] leftSortedList = quickSort_(segregateList[0]);
        Node[] rightSortedLIst = quickSort_(segregateList[2]);
        return mergeSortedList(leftSortedList, segregateList[1], rightSortedLIst);
    }

    static Node[] mergeSortedList(Node[] leftSortedList, Node pivotNode, Node[] rightSortedLIst) {
        Node head = null, tail = null;
        if (leftSortedList[0] != null && rightSortedLIst[0] != null) {
            leftSortedList[1].next = pivotNode;
            pivotNode.next = rightSortedLIst[0];
            head = leftSortedList[0];
            tail = rightSortedLIst[1];
        } else if (leftSortedList[0] != null) {
            head = leftSortedList[0];
            leftSortedList[1].next = pivotNode;
            tail = pivotNode;
        } else if (rightSortedLIst[0] != null) {
            head = pivotNode;
            pivotNode.next = rightSortedLIst[0];
            tail = rightSortedLIst[1];
        } else {
            head = tail = pivotNode;
        }
        return new Node[]{head, tail};
    }

    static int length(Node head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    static Node[] segreate(Node head, int pivotIdx) {
        Node smaller = new Node(-1);
        Node larger = new Node(-1);
        Node curr = head, sp = smaller, lp = larger, pivot = head;
        while (pivotIdx-- > 0)
            pivot = pivot.next;
        while (curr != null) {
            if (curr != pivot) {
                if (curr.data <= pivot.data) {
                    sp.next = curr;
                    sp = sp.next;
                } else {
                    lp.next = curr;
                    lp = lp.next;
                }
            }
            curr = curr.next;
        }
        sp.next = null;
        lp.next = null;
        pivot.next = null;
        return new Node[]{smaller.next, pivot, larger.next};
    }

}
