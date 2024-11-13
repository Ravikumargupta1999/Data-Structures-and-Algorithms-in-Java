public class SortedInsterCirculatLL {
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
    public static Node sortedInsert(Node head,int data)
    {
        Node new_node = new Node(data);
        Node temp = head;

        // Case 1 : LL is Empty
        if(temp == null)
        {
            new_node.next = head;
           head = new_node;
        }


        // case 2 : Before head
        else if(temp.data >= new_node.data)
        {
            while (temp.next != head)
                temp = temp.next;
            temp.next = new_node;
            new_node.next = head;
            head = new_node;
        }
        else
        {
            while (temp.next != head && temp.next.data < new_node.data)
            {
                temp = temp.next;
            }
            new_node.next = temp.next;
            temp.next = new_node;
        }


        return head;

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
    static void printList(Node node)
    {
        Node temp = node;

        while (node.next != temp)
        {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.print(node.data+" ");
        System.out.println();
    }
    public static void main(String[] args) {

        Node head = new Node(14);
        head.next = new Node(18);
        head.next.next = new Node(24);
        head.next.next.next = new Node(34);
        head.next.next.next.next = new Node(45);
        Node temp = head;
        while (temp.next!= null)
        {
            temp = temp.next;
        }
        temp.next = head;

        System.out.print("Linked list is : ");
        printList(head);


        boolean b = isCircular(head);
        if(b == true)
            System.out.println("Linked list is circular");
        else
            System.out.println("Linked list is not circular");
        System.out.print("Linked list is : ");

        System.out.println("");
        int data = 30;
        head = sortedInsert(head,data);
        System.out.print("Linked list is : ");
        printList(head);



    }

}
