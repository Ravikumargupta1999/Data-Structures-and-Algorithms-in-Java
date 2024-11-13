// https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1/?company[]=Adobe&company[]=Adobe&page=2&query=company[]Adobepage2company[]Adobe

public class Middle_Element_In_Linked_List {
    static class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    static int getMiddle(Node head)
    {
       int total = totalNode(head);
       Node temp = head;
       int i =0;
       while (i<(total/2))
       {
           temp = temp.next;
           i++;
       }
       return temp.data;

    }
    static int totalNode(Node node)
    {
        if(node == null)
            return 0;
        int i = 0;
        while (node.next != null)
        {
            node = node.next;
            i++;
        }
        i++;
        return i;
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        root.next = new Node(9);
        root.next.next = new Node(1);
        root.next.next.next = new Node(2);
        System.out.println(totalNode(root));
        System.out.println(getMiddle(root));

    }
}
