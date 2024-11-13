public class Linked_List_5_Merge_Two_sorted_linked_list_in_reverse_order {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1
    static Node mergeResult(Node node1, Node node2) {
        node1 = reverse(node1);
        node2 = reverse(node2);
        Node res = new Node(-1);
        Node temp = res;
        while (node1 != null && node2 != null) {
            if (node1.data > node2.data) {
                temp.next = node1;
                temp = temp.next;
                node1 = node1.next;
            } else if (node1.data < node2.data) {
                temp.next = node2;
                temp = temp.next;
                node2 = node2.next;
            } else {
                temp.next = node1;
                temp = temp.next;
                node1 = node1.next;

            }
        }
        if (node1 == null) {
            temp.next = node2;
        }
        if (node2 == null) {
            temp.next = node1;
        }

        return res.next;
    }

    static public Node reverse(Node node) {
        Node curr = node;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}

