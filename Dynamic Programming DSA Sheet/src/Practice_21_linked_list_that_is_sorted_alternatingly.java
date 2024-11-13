public class Practice_21_linked_list_that_is_sorted_alternatingly {
    // https://practice.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1?page=20&company[]=Amazon&sortBy=submissions
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public Node sort(Node head) {
        if (head == null || head.next == null)
            return head;

        if (head.next.next == null) {
            if (head.data < head.next.data)
                return head;
            else {
                int temp = head.data;
                head.data = head.next.data;
                head.next.data = temp;
                return head;
            }
        }

        Node temp = head.next.next;


        Node dummy1 = head;
        Node dummy2 = head.next;

        Node temp1 = dummy1;
        Node temp2 = dummy2;


        while (temp != null && temp.next != null) {
            Node first = temp;
            Node second = temp.next;

            temp1.next = first;
            temp2.next = second;


            temp1 = temp1.next;
            temp2 = temp2.next;


            temp = temp.next.next;

        }
        if (temp != null) {
            temp1.next = temp;
            temp1 = temp1.next;
        }

        temp2.next = null;
        temp1.next = null;

        Node l1 = head;
        Node l2 = reverse(dummy2);
        if (l1.data < l2.data)
            return merge(l1, l2);
        return merge(l2, l1);
    }

    public Node merge(Node n1, Node n2) {
        Node temp = n1;
        while (temp.next != null)
            temp = temp.next;
        temp.next = n2;
        return n1;
    }

    public Node reverse(Node head) {
        Node pre = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }

}
