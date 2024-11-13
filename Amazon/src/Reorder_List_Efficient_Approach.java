public class Reorder_List_Efficient_Approach {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
//https://practice.geeksforgeeks.org/problems/reorder-list/1/?company[]=Amazon&company[]=Amazon&difficulty[]=2&page=1&query=company[]Amazondifficulty[]2page1company[]Amazon

    static Node reorder_list(Node head) {
        if (head == null || head.next == null)
            return head;
        Node l1 = head;
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node l2 = reverse(slow);
        printlist(l1);
        printlist(l2);
        merge(l1,l2);
        printlist(head);
        return head;
    }

    public static Node reverse(Node head) {
        Node current, previous, next;
        current = head;
        previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    public static void merge(Node l1, Node l2) {
        while (l1 != null) {

            Node l1_next = l1.next;
            Node l2_next = l2.next;
            l1.next = l2;
            if (l1_next == null) {
                break;
            }
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
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
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(6);


        printlist(head); // Print original list

        reorder_list(head); // Modify the list
        printlist(head); // Print modified list

    }
}
