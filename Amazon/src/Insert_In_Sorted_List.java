public class Insert_In_Sorted_List {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/insert-in-a-sorted-list/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=6&query=company[]Amazondifficulty[]0page6company[]Amazon#
    static Node sortedInsert(Node head1, int key) {
        if (head1 == null)
            return new Node(key);
        if(head1.next == null)
        {
            if(key <= head1.data)
            {
                Node temp = new Node(key);
                temp.next = head1;
                return temp;
            }
            else
            {
                Node temp = head1;
                temp.next = new Node(key);
                return head1;
            }
        }

        if(key <= head1.data)
        {
            Node temp1 = new Node(key);
            temp1.next = head1;
            return temp1;
        }
        Node temp = head1;
        while (temp.next != null)
        {
            System.out.println(temp.data+"  hello");
            if(key >= temp.data && key <= temp.next.data)
            {
                Node node = new Node(key);
                Node val = temp.next;
                temp.next = node;
                node.next = val;
                return head1;
            }
            temp = temp.next;
        }
        temp.next = new Node(key);
        return head1;
    }

    public static void main(String[] args) {
        Node root = new Node(25);
        root.next = new Node(36);
        root.next.next = new Node(47);
        root.next.next.next = new Node(58);
        root.next.next.next.next = new Node(69);
        root.next.next.next.next.next = new Node(84);
        root = sortedInsert(root,276);
        while (root != null) {
            System.out.print(root.data + "  ");
            root = root.next;
        }
    }
}
//6
//        25 36 47 58 69 80
//        29