public class Linked_List_29_Segregate_0_1_2_Node {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;

        }
    }
    // https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

    static Node segregate(Node head) {
       if(head == null || head.next == null)
           return head;
       Node zero = new Node(-1);
       Node pz = zero;
       Node one = new Node(-1);
       Node po = one;
       Node two = new Node(-1);
       Node pt = two;
       Node curr = head;
       while (curr != null)
       {
           if(curr.data == 0)
           {
               pz.next = curr;
               pz = pz.next;
           }
           else if(curr.data == 1)
           {
               po.next = curr;
               po = po.next;
           }
           else
           {
               pt.next = curr;
               pt = pt.next;
           }
           curr = curr.next;
       }
       po.next = two.next;
       pt.next = null;
       pz.next = one.next;
       return zero.next;
    }
}
