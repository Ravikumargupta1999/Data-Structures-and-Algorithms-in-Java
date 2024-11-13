public class Linked_List_In_Forrward_Backward_Recursion {
    Node head;
    static class Node
    {

        int data;
        Linked_List_In_Forrward_Backward_Recursion.Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static Linked_List_In_Forrward_Backward_Recursion insert_at_end(Linked_List_In_Forrward_Backward_Recursion list, int data)
    {
        Linked_List_In_Forrward_Backward_Recursion.Node temp = new Linked_List_In_Forrward_Backward_Recursion.Node(data);
        temp.next = null;
        if (list.head == null)
        {
            list.head = temp;
        }
        else
        {
            Linked_List_In_Forrward_Backward_Recursion.Node p = list.head;
            while (p.next != null)
            {
                p = p.next;
            }
            p.next = temp;
        }
        return list;
    }
    public static void forward_Traversal(Node head)
    {
        if(head == null)
        {
            return;
        }
        System.out.print(head.data+"   ");
        forward_Traversal(head.next);
    }
    public static void backward_Traversal(Node head)
    {
        if(head == null)
        {
            return;
        }
        backward_Traversal(head.next);
        System.out.print(head.data+"   ");

    }

    public static void main(String[] args) {
        Linked_List_In_Forrward_Backward_Recursion list = new Linked_List_In_Forrward_Backward_Recursion();
        insert_at_end(list,78);
        insert_at_end(list,26);
        insert_at_end(list,43);
        insert_at_end(list,93);
        insert_at_end(list,89);

        System.out.print("Forward Reverse  :  ");
        forward_Traversal(list.head);
        System.out.println("");

        System.out.print("Backward Reverse :  ");
        backward_Traversal(list.head);
        System.out.println("");



    }
}
