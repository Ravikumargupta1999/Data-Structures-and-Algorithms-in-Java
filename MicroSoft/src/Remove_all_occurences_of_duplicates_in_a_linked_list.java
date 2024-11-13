//https://practice.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1/?company[]=Microsoft&company[]=Microsoft&page=20&query=company[]Microsoftpage20company[]Microsoft
public class Remove_all_occurences_of_duplicates_in_a_linked_list {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeAllDuplicates(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        if (head.next.next == null) {
            if (head.data == head.next.data)
                return null;
            return head;
        }
        Node res = new Node(-1);
        //   res.data = -1;
        Node temp1 = res;


        int previous = head.data;
        Node temp = head;
        if (head.data == head.next.data) {
            temp = temp.next;

        } else {
            temp1.next = new Node(previous);
            //   temp1.data = previous;
            temp1 = temp1.next;

            temp = temp.next;
        }
        while (temp.next != null) {
            if (temp.data != previous && temp.data != temp.next.data) {
                temp1.next = new Node(temp.data);
                //   temp1.next.data = temp.data;
                temp1 = temp1.next;

                previous = temp.data;
            } else {
                previous = temp.data;
                temp = temp.next;
            }
        }
        if (temp.data != previous) {
            temp1.next = new Node(temp.data);
            temp1.next.data = temp.data;
            temp1 = temp1.next;

            previous = temp.data;
        }
        return res.next;
    }

    public static void main(String[] args) {
        
    }
}
