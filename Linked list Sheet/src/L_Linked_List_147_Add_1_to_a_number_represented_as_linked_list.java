public class L_Linked_List_147_Add_1_to_a_number_represented_as_linked_list {
    //https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1#
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
//    public static Node reverse(Node node){
//        Node curr,next,prev;
//        prev = null;
//        next = null;
//        curr = node;
//        while (curr != null)
//        {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
//    public static Node addOne(Node head)
//    {
//        Node rev = reverse(head);
//
//        Node curr = rev;
//        int rem = 1;
//        Node next,prev;
//        prev = null;
//        next = null;
//        while (curr != null)
//        {
//            int data = curr.data + rem;
//            curr.data = data % 10;
//            rem = data / 10;
////            System.out.println(data+"   "+curr.data+"   "+rem);
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        if(rem == 0)
//            return prev;
//        else
//        {
//            Node dummy = new Node(1);
//            dummy.next = prev;
//            return dummy;
//        }
//    }
//    static void printList(Node node)
//        {
//        while (node != null)
//        {
//            System.out.print(node.data+" ");
//            node = node.next;
//        }
//        System.out.println();
//    }


    //    1 2 3


    //    3 2 1
    //    1
    //    4 2 1
    public static Node addOne(Node head) {
        head = reverse(head);

        int carry = 1;

        Node curr = head;
        Node prev = null;
        while (curr != null) {

            int num = curr.data + carry;

            curr.data = num % 10;

            carry = num / 10;

            prev = curr;

            curr = curr.next;
        }

        if (carry != 0)
            prev.next = new Node(carry);
        return reverse(head);


    }

    static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
