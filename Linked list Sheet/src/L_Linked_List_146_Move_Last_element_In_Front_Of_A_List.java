public class L_Linked_List_146_Move_Last_element_In_Front_Of_A_List {

    public class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // https://www.codingninjas.com/codestudio/problems/let-last-be-the-first_920455?leftPanelTab=1
    public static LinkedListNode moveToFront(LinkedListNode head) {
        if (head == null || head.next == null)
            return head;
        LinkedListNode node = head;
        LinkedListNode prev = null; // Keeps track of second last element to makes its next null
        while (head.next != null) {
            prev = head;
            head = head.next;
        }
        prev.next = null;
        head.next = node;
        return head;
    }

}
