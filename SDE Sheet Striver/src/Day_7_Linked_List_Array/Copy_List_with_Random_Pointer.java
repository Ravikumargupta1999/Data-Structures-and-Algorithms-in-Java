package Day_7_Linked_List_Array;

public class Copy_List_with_Random_Pointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // add node between list
        Node curr = head;
        while (curr != null) {

            Node next = curr.next;

            Node newNode = new Node(curr.val);

            curr.next = newNode;
            newNode.next = next;

            curr = next;

        }


        // copy random pointer
        curr = head;
        while (curr != null){

            Node next = curr.next.next;

            Node newNode = curr.next;

            newNode.random = curr.random == null ? null: curr.random.next;

            curr = next;

        }


        Node dummy = new Node(-1);
        Node temp = dummy;

        curr = head;

        while (curr != null){

            Node next = curr.next.next;

            temp.next = curr.next;
            temp = temp.next;

            curr.next = next;
            curr = next;
        }
        return dummy.next;
    }
}
