import java.util.Stack;

public class S_Stack_Queue_337_Reverse_A_Linked_list_UsingStack {
    static class Node
    {
        int data ;
        Node next;
        Node (int d)
        {
            data = d;
            next = null;
        }
    }
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }
    public static  Node reverse(Node head)
    {
        if(head == null)
            return null;
        else if(head.next == null)
            return head;
        Stack<Node> stack = new Stack<>();

        Node temp = head;
        while (temp != null)
        {
            stack.push(temp);
            temp = temp.next;
        }
        head = stack.peek();
        temp = stack.peek();
        stack.pop();
        while (!stack.isEmpty())
        {
            temp.next = stack.peek();
            stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return head;

    }
    public static void main(String[] args) {

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        System.out.print("List is : ");
        printList(head1);
        head1 = reverse(head1);
        System.out.print("List is : ");
        printList(head1);

    }
}
