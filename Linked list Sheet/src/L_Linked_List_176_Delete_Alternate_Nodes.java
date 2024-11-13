
//https://practice.geeksforgeeks.org/problems/delete-alternate-nodes/1/?category[]=Linked%20List&category[]=Linked%20List&page=1&query=category[]Linked%20Listpage1category[]Linked%20List#

public class L_Linked_List_176_Delete_Alternate_Nodes {
    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
    public static void deleteAlternate (Node head){
        Node temp = head;
        while (temp.next != null)
        {
            System.out.print(temp.data+"  ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        System.out.println("");



        Node prev = head;
        Node now = head.next;
        while (prev != null && now != null)
        {
            prev.next = now.next;
            now = null;
            prev = prev.next;
            if (prev != null)
                now = prev.next;
        }


        System.out.println("");
        Node root = head;
        while (root.next != null)
        {
            System.out.print(root.data+"  ");
            root = root.next;
        }
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        deleteAlternate(node);
    }
}
