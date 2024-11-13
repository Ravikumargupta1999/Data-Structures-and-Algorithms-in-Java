public class L_Linked_List_140_Reverse_In_Group_Of_Size_K {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://www.youtube.com/watch?v=znQ8wJxnRao
    // https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
    public static Node reverse(Node node, int k) {
        if(node == null)
            return null;
        int temp = k;
        Node curr = node;
        Node prev = null;

        while (curr != null && k-- > 0) {

            Node next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
        }

        if(curr != null)
            node.next = reverse(curr,temp);
        return prev;
    }


}
