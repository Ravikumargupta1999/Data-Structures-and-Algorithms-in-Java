public class L_Linked_List_158_Reverse_a_Doubly_Linked_List {
    Node head;

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    public static Node reverseDLL(Node head) {
//        Node curr = head;
//        Node temp = curr;
//        if(curr == null)
//            return null;
//        else if(curr.next == null)
//        {
//            return head;
//        }
//        while(curr != null)
//        {
//            temp = curr.prev;
//            curr.prev = curr.next;
//            curr.next = temp;
//            curr = curr.prev;
//        }
//        if(temp != null)
//            temp = temp.prev;
//        return temp;


//        if (head == null || head.next == null)
//            return head;
//        Node curr = head;
//        Node prev = null;
//        Node next = null;
//
//        while (curr != null) {
//
//            Node node = curr;
//
//            // store prev and next node
//            next = node.next;
//            prev = node.prev;
//
//            // exchange prev and next
//            node.next = prev;
//            node.prev = next;
//
//            // maintain prev for last node if curr becomes null so that you can get which was last node
//            prev = curr;
//            curr = next;
//
//        }
//        return prev;


        Node curr = head;

        if (head.next == null)
            return head;

        Node prev = null;

        while (curr != null) {


            Node next = curr.next;
            curr.prev = next;
            curr.next = prev;

            prev = curr;

            curr = next;

        }
        return prev;


    }


}

