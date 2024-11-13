public class L_Linked_List_154_Check_For_Circular_Linked_List {
    static class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    static boolean isCircular(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.next  == head )
                return true;
            temp = temp.next;
        }
        return false;

    }

}
