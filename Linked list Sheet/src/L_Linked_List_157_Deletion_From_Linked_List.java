public class L_Linked_List_157_Deletion_From_Linked_List {
    // https://www.youtube.com/watch?v=TTialWzRTdY&list=RDGMEMQvslUU5QcbUzJ7HyWoWAAA&index=3
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public static Node<Integer> deleteNode(Node<Integer> head, int key) {
        if (head == null)
            return null;

        if (!isPresent(head, key))
            return head;
        if (head.next == head && head.data == key)
            return null;
        if (head.data == key)
            return delteFirstNode(head);
        Node<Integer> curr = head;
        while (curr.next.data != key) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static boolean isPresent(Node<Integer> head, int key) {
        Node<Integer> temp = head;

        while (temp.next != head) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return temp.data == key ? true : false;
    }

    public static Node<Integer> delteFirstNode(Node<Integer> node) {

        Node<Integer> first = node;

        while (first.next != node) {
            first = first.next;
        }
        first.next = node.next;
        return node.next;
    }
}
