public class L_Linked_List_179_Swap_Kth_Nodes_From_Ends {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    //Function to swap Kth node from beginning and end in a linked list.
    static Node swapkthnode(Node head, int num, int k) {
        // your code here
        int length = length(head);

        if (k > length || length == 1)
            return head;
        if (k == 1 || k == num)
            return swapKEqualOne(head);
        int temp1 = k;
        int temp2 = num - k + 1;

        if (temp1 == temp2)
            return head;
        if (temp2 < temp1) {
            int temp = temp1;
            temp1 = temp2;
            temp2 = temp;
        }

        Node startNode = head;
        Node endNode = head;

        for (int i = 1; i < temp1 - 1; i++) {
            startNode = startNode.next;
        }

        for (int i = 1; i < temp2 - 1; i++) {
            endNode = endNode.next;
        }

        if (startNode.next == endNode) {

            Node next1 = startNode.next;
            Node next2 = endNode.next;

            next1.next = next2.next;
            next2.next = next1;
            startNode.next = next2;

            return head;
        }
        Node startNext = startNode.next;
        Node startSNextNext = startNode.next.next;


        Node endNext = endNode.next;
        Node endSNextNext = endNode.next.next;

        startNode.next = endNext;
        endNext.next = startSNextNext;

        endNode.next = startNext;
        startNext.next = endSNextNext;


        return head;
    }

    static Node swapKEqualOne(Node node) {

        Node start = node;

        Node curr = node;
        Node prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = start;
        curr.next = start.next;
        start.next = null;

        return curr;
    }

    static int length(Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void print(Node node) {

        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        print(head);
        print(swapkthnode(head, length(head), 6));

    }
}
