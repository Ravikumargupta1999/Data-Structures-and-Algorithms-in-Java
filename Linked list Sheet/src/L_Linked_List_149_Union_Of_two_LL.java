import java.util.*;

//https://practice.geeksforgeeks.org/problems/union-of-two-linked-list/1/?category[]=Linked%20List&category[]=Linked%20List&page=2&query=category[]Linked%20Listpage2category[]Linked%20List#

public class L_Linked_List_149_Union_Of_two_LL {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public  Node findUnion(Node head1,Node head2)
    {
        ArrayList<Integer> al = new ArrayList<>();
        Node temp1 = head1;
        while (temp1 != null)
        {
            al.add(temp1.data);
            temp1 = temp1.next;
        }

        Node temp2 = head2;
        while (temp2 != null)
        {
            al.add(temp2.data);
            temp2 = temp2.next;
        }
        Collections.sort(al);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<al.size();i++)
        {
            if(al.get(i) == pq.peek())
            {
                continue;
            }
            else
                pq.add(al.get(i));

        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        while (!pq.isEmpty())
            pq1.add(pq.poll());

        Node head = new Node(pq1.poll());
        Node temp = head;
        while (!pq1.isEmpty())
        {
            temp.next = new Node(pq1.poll());
            temp = temp.next;
        }
        return head;
    }
}
