import javax.sql.rowset.spi.SyncFactoryException;

// Leetcode
public class Insertion_Sort_for_Singly_Linked_List {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
    //https://leetcode.com/problems/insertion-sort-list/submissions/
    public static ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode res = null;
        ListNode temp = head;
        while (temp != null) {
            if (res == null) {
                res = new ListNode(temp.val);
            } else if (res.val >= temp.val) {
                ListNode newNode = new ListNode(temp.val);
                newNode.next = res;
                res = newNode;
            } else {
                boolean found = false;
                ListNode curr = res;
                while (curr.next != null && curr.val < temp.val) {
                    if (found)
                        break;
                    if (temp.val > curr.next.val) {
                        curr = curr.next;
                        continue;

                    }
                    ListNode temp1 = curr.next;
                    curr.next = new ListNode(temp.val);
                    curr.next.next = temp1;
                    found = true;
                }
                if (!found) {
                    curr.next = new ListNode(temp.val);
                }
            }
//            ListNode a = res;
//            while (a != null) {
//                System.out.print(a.val + "  ");
//                a = a.next;
//            }
//            System.out.println("");
            temp = temp.next;
        }

        return res;
    }


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

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(0);
        ListNode res = insertionSortList(head);
        ListNode a = res;
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
        System.out.println("");
    }
}
// 30 23 28 30 11 14 19 16 21 25