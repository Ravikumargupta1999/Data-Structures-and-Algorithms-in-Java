//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=1&query=company[]Goldman%20Sachspage1company[]Goldman%20Sachs#

public class Delete_Without_Head_Pointer {
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    void deleteNode(Node pos)
    {
        if (pos == null)
            return;
        else
        {

            if (pos.next == null)
            {
                return;
            }

            Node temp = pos.next;
            pos.data = pos.next.data;
            pos.next = pos.next.next;
        }

    }

    public static void main(String[] args) {

    }
}
