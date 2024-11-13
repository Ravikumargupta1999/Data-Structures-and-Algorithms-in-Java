package InterviewQuestion;

public class Video_62_Clone_A_linked_ist_With_Next_And_Random_Pointer {

    // https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
    //
    class Node {
        int data;
        Node next, arb;

        Node(int d) {
            data = d;
            next = arb = null;

        }
    }

    Node copyList(Node head) {
        if (head == null)
            return null;
        Node curr = head;

        while (curr != null) {

            Node next = curr.next;

            Node newNode = new Node(curr.data);

            newNode.next = next;

            curr.next = newNode;

            curr = next;

        }


        curr = head;

        while (curr != null) {

            Node next = curr.next.next;

            curr.next.arb = curr.arb == null ? null : curr.arb.next;

            curr = next;
        }

        Node original = head;

        Node copy = head.next;

        Node temp = copy;

        while (original != null && copy != null) {

            original.next = original.next.next;
            copy.next = copy.next == null ? null : copy.next.next;

            original = original.next;
            copy = copy.next;
        }
        return temp;

    }
}
