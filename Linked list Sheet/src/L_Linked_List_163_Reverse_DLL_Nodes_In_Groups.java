public class L_Linked_List_163_Reverse_DLL_Nodes_In_Groups {
    class Node {
        public int data;
        public Node next;
        public Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    // https://www.codingninjas.com/codestudio/problems/reverse-dll-nodes-in-groups_920399?leftPanelTab=0
    public static Node reverseDLLInGroups(Node head, int k) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        Node prev = null;
        Node next = null;
        int c = k;
        while (curr != null && c > 0) {

            Node node = curr;

            // store prev and next node
            next = node.next;
            prev = node.prev;

            // exchange prev and next
            node.next = prev;
            node.prev = next;

            // maintain prev for last node if curr becomes null so that you can get which was last node
            prev = curr;
            curr = next;

            c--;

        }


        Node newNode = reverseDLLInGroups(next, k);

        // I didn't understand this
//      newNode.prev = head;
        head.next = newNode;

        return prev;
    }


}
