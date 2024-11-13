public class L_Linked_List_156_Check_if_Linked_List_is_Palindrome {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static boolean isPalindrome(Node head) {
        // Find mid
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        printList(slow);
        printList(fast);
        slow = reverse(slow);
        printList(slow);
        printList(fast);

        while (slow != null) {
            if (fast.data != slow.data)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node next;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        System.out.print("List is ");
        printList(head);
        boolean b = isPalindrome(head);
        if (b)
            System.out.println("List is Palindrome");
        else
            System.out.println("List is not palindrome");

    }
}
