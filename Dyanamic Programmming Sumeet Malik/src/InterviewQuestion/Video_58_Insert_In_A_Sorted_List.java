package InterviewQuestion;

public class Video_58_Insert_In_A_Sorted_List {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node sortedInsert(Node head1, int key) {
        if (head1 == null)
            return new Node(key);
        else if (key <= head1.data) {
            Node temp = new Node(key);
            temp.next = head1;
            return temp;
        }

        Node temp = head1;

        while (temp.next != null) {
            if (key >= temp.data && key <= temp.next.data) {

                Node newNode = new Node(key);
                newNode.next = temp.next;
                temp.next = newNode;
                return head1;
            }
            temp = temp.next;
        }
        temp.next = new Node(key);
        return head1;
    }
}
