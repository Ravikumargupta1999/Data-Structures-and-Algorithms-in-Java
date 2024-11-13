package InterviewQuestion;

public class Video_63_Reorder_List {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node reorderList(Node head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;


        Node middleNode = getMiddleNode(head);
        Node temp1 = head;
        Node temp2 = reverseList(middleNode.next);
        middleNode.next = null;



        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (temp1 != null && temp2 != null) {

            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;

            temp.next = temp2;
            temp = temp.next;
            temp2 = temp2.next;

        }

        if (temp1 != null)
            temp.next = temp1;
        return dummyNode.next;
    }


    static Node reverseList(Node head) {
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

    static Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "\t");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {


        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        printList(reorderList(node));


    }

}
