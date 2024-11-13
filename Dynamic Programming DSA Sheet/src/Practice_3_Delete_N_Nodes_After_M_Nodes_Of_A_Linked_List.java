public class Practice_3_Delete_N_Nodes_After_M_Nodes_Of_A_Linked_List {
    // https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1?page=11&company[]=Amazon&sortBy=submissions
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void linkDelete(Node head, int M, int N) {
        delete(head, M, N);
    }

    public static Node delete(Node head, int M, int N) {

        if (head == null || size(head) <= M)
            return head;

        Node temp = head;
        Node pre = null;
        Node next = null;

        int m = M;
        int n = N;


        while (m-- > 0) {
            pre = temp;
            temp = temp.next;
            next = temp;
        }

        while (n-- > 0) {
            if (next == null)
                break;
            else
                next = next.next;
        }
        pre.next = delete(next, M, N);
        return head;
    }

    static int size(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + "  ");
            head = head.next;
        }
        System.out.println("");
    }

    //    9 1 3 5 9 4 10 1
    public static void main(String[] args) {
        Node node = new Node(9);
        node.next = new Node(1);
        node.next.next = new Node(3);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(9);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(10);
        node.next.next.next.next.next.next.next = new Node(1);
        print(node);
        linkDelete(node, 1, 1);
        print(node);

    }
}
