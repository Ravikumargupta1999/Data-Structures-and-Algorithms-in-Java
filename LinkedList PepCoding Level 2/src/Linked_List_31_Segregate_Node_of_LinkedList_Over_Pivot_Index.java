public class Linked_List_31_Segregate_Node_of_LinkedList_Over_Pivot_Index {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;

        }
    }

    static Node segregate(Node head,int pivotIdx) {

        if (head == null || head.next == null)
            return head;

        Node curr = head;
        int idx = 0;
        int data =0;
        while (curr != null)
        {
            if(idx == pivotIdx)
            {
                data = curr.data;
                break;
            }
            curr = curr.next;
            idx++;
        }
        System.out.println(data);
        Node smaller = new Node(-1);
        Node pr = smaller;
        Node larger = new Node(-1);
        Node pl = larger;
        curr = head;
        idx = 0;
        Node pivot = null;
        while (curr != null) {
            if( idx == pivotIdx)
            {
                pivot = curr;
            }
            else if (curr.data <= data) {
                pr.next = curr;
                pr = pr.next;
            } else {
                pl.next = curr;
                pl = pl.next;
            }
            curr = curr.next;
            idx++;
        }
        pr.next = pivot;
        pivot.next = larger.next;
        pl.next = null;
        return smaller.next;
    }
    static Node getTail(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node tail = head;
        while (tail.next != null)
        {
            tail = tail.next;
        }
        return tail;
    }
    static void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+"  ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(11);
        head.next.next = new Node(31);
        head.next.next.next = new Node(91);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next.next.next = new Node(9);
        printList(head);
        printList(segregate(head,10));
    }
}
