import java.util.PriorityQueue;

public class Linked_List_8_Merge_k_Sorted_Lists_Priority_Queue {
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
    //https://leetcode.com/problems/merge-k-sorted-lists/submissions/

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        for (ListNode l : lists)
            if (l != null)
                pq.add(l);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (pq.size() != 0) {
            ListNode p = pq.poll();
            temp.next = p;
            temp = temp.next;
            p = p.next;
            if (p != null)
                pq.add(p);
        }
        return dummy.next;
    }
}
