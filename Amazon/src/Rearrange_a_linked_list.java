public class Rearrange_a_linked_list {
    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/rearrange-a-linked-list/1
    void rearrangeEvenOdd(Node head) {
        if(head == null || head.next == null)
            return ;
        Node h_odd = head;
        Node h_even = head.next;
        Node odd =h_odd;
        Node even = h_even;
        while (even != null)
        {
            if(even.next != null)
            {
                odd.next = even.next;
            }
            else
            {
                odd.next = h_even;
                return ;
            }
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = h_even;
        return ;

    }

    class ListNode {
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
    // https://leetcode.com/problems/odd-even-linked-list/submissions/
    public ListNode oddEvenList(ListNode head) {
      if(head == null || head.next == null)
          return head;
      ListNode h_odd = head;
      ListNode h_even = head.next;
      ListNode odd =h_odd;
      ListNode even = h_even;
      while (even != null)
      {
          if(even.next != null)
          {
              odd.next = even.next;
          }
          else
          {
              odd.next = h_even;
              return h_odd;
          }
          odd = odd.next;
          even.next = odd.next;
          even = even.next;
      }
      odd.next = h_even;
      return h_odd;
    }
}
