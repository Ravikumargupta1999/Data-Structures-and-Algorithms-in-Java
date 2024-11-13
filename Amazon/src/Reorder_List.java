import java.util.ArrayList;

public class Reorder_List {
    static class Node
    {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    static Node reorderlist(Node head) {
        if(head == null)
            return null;
        ArrayList<Integer> al = new ArrayList<>();
        Node curr = head;
        while ( curr!= null)
        {
            al.add(curr.data);
            curr = curr.next;
        }
//        System.out.println("Hello");
        ArrayList<Integer> al1 = new ArrayList<>();
        int i=0;
        int n = al.size()-1;
        while (i < al.size()/2)
        {
            if(i == n)
                al1.add(al.get(i));
            else {
                al1.add(al.get(i));
                al1.add(al.get(n));
            }
            n--;
            i++;
//            System.out.println("hhaddg");
        }
        if(al.size() %2 != 0)
        {
            al1.add(al.get(i));
        }
//
        System.out.println(al);
        System.out.println(al1);

        i = 1;
        Node temp = head;
        while (i<al1.size())
        {
            temp.next = new Node(al1.get(i));
            temp = temp.next;
            i++;
        }
        printlist(head);
        return head;
    }
    static void printlist(Node node) {
        if (node == null) {
            return;
        }
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
        System.out.println("");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
//        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(6);


        printlist(head); // Print original list

        reorderlist(head); // Modify the list
        printlist(head); // Print modified list

    }
}
