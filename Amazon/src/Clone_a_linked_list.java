public class Clone_a_linked_list {
    class Node {
        int data;
        Node next, arb;

        Node(int d)
        {
            data = d;
            next = arb = null;

        }
    }
    //https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1/?company[]=Amazon&company[]=Amazon&difficulty[]=2&page=1&query=company[]Amazondifficulty[]2page1company[]Amazon
    // https://leetcode.com/problems/copy-list-with-random-pointer/submissions/

    Node copyList(Node head) {
        Node curr = head;
        Node temp;
        while (curr != null)
        {
            temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        while (curr != null)
        {
            if (curr.next != null)
                curr.next.arb = (curr.arb != null) ? curr.arb.next : curr.arb;
            curr =curr.next.next;
        }

        Node original= head;
        Node copy = head.next;
        temp = copy;
        while (original != null && copy != null)
        {
            original.next = original.next.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }
}
