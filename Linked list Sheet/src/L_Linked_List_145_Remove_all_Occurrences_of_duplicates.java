public class L_Linked_List_145_Remove_all_Occurrences_of_duplicates {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node removeAllDuplicates(Node head) {
        int prev = -1;

        Node dummy = new Node(-1);

        Node temp = dummy;

        Node curr = head;

        while (curr.next != null) {
            if (curr.data != prev && curr.data != curr.next.data) {
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
        }
        if(curr.data != prev){
            temp.next = curr;
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;
    }
}
//https://practice.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1/?category[]=Linked%20List&category[]=Linked%20List&page=5&query=category[]Linked%20Listpage5category[]Linked%20List
