public class BST_235_Sorted_Linked_List_To_BST {

// https://practice.geeksforgeeks.org/problems/sorted-list-to-bst/0/?fbclid=IwAR23ImBXxUeHmTcjMzmUdgir1YbdwDLQKw18XKe1rcRWpj2d5YxCaZduPwA#

    static class LNode {
        int data;
        LNode next;

        LNode(int d) {
            data = d;
            next = null;
        }
    }


    static class TNode {
        int data;
        TNode left, right;

        TNode(int x) {
            data = x;
            left = right = null;
        }

    }


    public static TNode sortedListToBST(LNode head) {
        return formTree(head);
    }

    public static TNode formTree(LNode node) {
        if (node == null)
            return null;
        if (node.next == null)
            return new TNode(node.data);

        LNode[] midNode = getMidNode(node);


        if (midNode[1] == null)
            return null;

        TNode newNode = new TNode(midNode[1].data);


        newNode.left = formTree(midNode[0]);

        newNode.right = formTree(midNode[2]);

        return newNode;
    }

    public static LNode[] getMidNode(LNode node) {
        if (node == null)
            return new LNode[]{null, null, null};
        if (node.next == null) {
            return new LNode[]{null, node, null};
        }
        if (node.next.next == null) {
            LNode first = node;
            LNode second = node.next;

            node.next = null;

            return new LNode[]{first, second, null};
        }
        LNode slow = node;
        LNode fast = node;
        LNode prev = null;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        LNode last = slow.next;
        slow.next = null;
        return new LNode[]{node, slow, last};
    }
    public static void inOrder(TNode head) {
        if (head == null)
            return;
        inOrder(head.left);
        System.out.print(head.data + "  ");
        inOrder(head.right);
    }

    public static void main(String[] args) {
        LNode head = new LNode(1);
        head.next = new LNode(2);


        TNode node = sortedListToBST(head);
        inOrder(node);
    }

}
