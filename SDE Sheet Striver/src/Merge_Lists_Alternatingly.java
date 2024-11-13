public class Merge_Lists_Alternatingly {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    // https://practice.geeksforgeeks.org/problems/merge-list-alternatingly/1?page=22&company[]=Amazon&sortBy=submissions
    public void mergeAlt(Node head1, Node head2) {
        //write your code here, and print the result

        Node rev1 = head1;

        Node rev2 = head2;

        Node curr1 = rev1;

        while (curr1 != null && rev2 != null) {

            Node temp = curr1.next;

            Node newNode = new Node(rev2.data);

            newNode.next = temp;

            curr1.next = newNode;

            curr1 = temp;

            rev2 = rev2.next;

        }

        while (rev1 != null) {

            System.out.print(rev1.data + " ");

            rev1 = rev1.next;

        }

        System.out.println();

        while (rev2 != null) {

            System.out.print(rev2.data + " ");

            rev2 = rev2.next;

        }
    }
}
