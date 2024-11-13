package InterviewQuestion;

public class Video_67_Sorted_Linked_List_To_BST {

    // https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class ListNode {
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

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);


        ListNode middle = middleNode(head);
        TreeNode treeNode = new TreeNode(middle.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(middle.next);
        middle.next = null;
        return treeNode;

    }

    public ListNode middleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            if (prev != null)
                prev.next = null;
            return slow;
        } else {
            ListNode res = slow.next;
            slow.next = null;
            return res;
        }
    }

    // https://practice.geeksforgeeks.org/problems/sorted-list-to-bst/1
    class TNode {
        int data;
        TNode left, right;

        TNode(int x) {
            data = x;
            left = right = null;
        }
    }

    class LNode {
        int data;
        LNode next;

        LNode(int d) {
            data = d;
            next = null;
        }
    }
    
    public TNode sortedListToBST(LNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TNode(head.data);

        LNode middleNode = getMiddleNode(head);

        TNode treeNode = new TNode(middleNode.data);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(middleNode.next);
        middleNode.next = null;
        return treeNode;
    }

    public LNode getMiddleNode(LNode node) {
        LNode slow = node;
        LNode fast = node;
        LNode prev = null;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            if (prev != null)
                prev.next = null;
            return slow;
        } else {
            LNode res = slow.next;
            slow.next = null;
            return res;
        }
    }

}
