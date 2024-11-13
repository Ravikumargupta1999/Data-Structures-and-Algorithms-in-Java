public class L_Linked_List_153_Delete_Middle_Of_LL {
    static class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
   static Node deleteMid(Node head) {
        if(head == null)
            return null;
        else if(head.next == null)
            return null;
        else if(head.next.next == null)
        {
            head.next = null;
            return head;
        }

        int total = count(head);
        Node temp = head;
        int i=0;
        while (i != total/2-1)
        {
            temp =  temp.next;
            i++;
        }
        System.out.println(temp.data);
        System.out.println(temp.next.next.data);
        temp.next = temp.next.next;
        return head;


    }
    static int count(Node head)
    {
        Node temp = head;
        int count =0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        L_Linked_List_153_Delete_Middle_Of_LL a = new L_Linked_List_153_Delete_Middle_Of_LL();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        deleteMid(head);
    }
}
//https://practice.geeksforgeeks.org/problems/delete-middle-of-linked-list/1/?category[]=Linked%20List&category[]=Linked%20List&page=2&query=category[]Linked%20Listpage2category[]Linked%20List#