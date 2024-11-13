public class Linked_List_12_Reverse_Nodes_in_k_Group {
    public static class ListNode {
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

    // https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
    public ListNode reverseKGroup(ListNode node, int k) {
        ListNode next, curr, prev;
        next = null;
        prev = null;
        curr = node;
        int c = 0;
        while (curr != null && c < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }
        if (next != null && size(next) >= k)
            node.next = reverseKGroup(next, k);
        else
            node.next = next;
        return prev;

    }


    public static int size(ListNode node) {
        ListNode temp = node;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
