package Biweekly_Contest_69;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Twin_Sum_of_a_Linked_List {
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

    public int pairSum(ListNode head) {
        int len = length(head) / 2;
        int max = 0;

        ListNode curr = head;
        List<Integer> l = new ArrayList<>();
        while (curr != null)
        {
            l.add(curr.val);
            curr = curr.next;
        }
        int j = l.size()-1;
        while (len-- > 0){
            max = Math.max(max,l.get(j) + head.val);
            head = head.next;
            j--;
        }
        return max;

    }

    public int length(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
