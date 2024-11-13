public class Doubly_linked_list {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    static Node head = null;

    static void addNode(Node head_ref, int pos, int data) {
        System.out.println("Data " + data);
        Node temp = head_ref;
        Node prev = null;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        Node next = temp.next;
        Node newNode = new Node(data);
        temp.next = newNode;
        if (next != null) {
            next.prev = newNode;
            newNode.next = next;
        }
        forwardTraversal(head_ref);

    }

    static void addFirst(int data) {
        if (head == null) {
            head = new Node(data);
            forwardTraversal(head);
            return;
        }
        Node temp = new Node(data);
        head.prev = temp;
        temp.next = head;
        head = temp;
        forwardTraversal(head);
    }

    static void removeFirst() {
        if (head == null)
            return;
        head = head.next;
        forwardTraversal(head);
    }
    static void removeLast()
    {
        if(head == null) {
            forwardTraversal(head);
            return;
        }
        if(head.next == null)
        {
            head = null;
            forwardTraversal(head);
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        forwardTraversal(head);
    }

    static void forwardTraversal(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
        System.out.print("\n");

    }
    static int getLast()
    {
        if(head == null)
            return -1;
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        return temp.data;
    }
    static int getFirst()
    {
        if(head == null)
            return -1;
        return head.data;
    }

    public static void main(String[] args) {


        System.out.print("Addition First : ");
        addFirst(8);
        System.out.print("Removal  Last  : ");
        removeLast();
        System.out.print("Addition First : ");
        addFirst(5);
        System.out.print("Removal  First : ");
        removeFirst();

        System.out.print("Addition First : ");
        addFirst(1);
        System.out.print("Addition First : ");
        addFirst(10);
        System.out.print("Addition First : ");
        addFirst(27);
        System.out.print("Removal  Last  : ");
        removeLast();
        System.out.print("Get      Last  : "+getLast()+"\n");
        System.out.print("Get     First  : "+getFirst()+"\n");

    }
}
