public class Practice_19_Linked_List_In_Zig_Zag_Fashion {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node zigZag(Node head) {
        if (head == null || head.next == null)
            return head;

        if (head.data > head.next.data) {
            int temp = head.data;
            head.data = head.next.data;
            head.next.data = temp;
        }

        boolean flag = true;

        Node temp = head.next;

        while (temp.next != null) {
            if (flag) {

                Node curr = temp;
                Node next = temp.next;

                if (curr.data < next.data) {
                    int val = curr.data;
                    curr.data = next.data;
                    next.data = val;
                }
            } else {
                Node curr = temp;
                Node next = temp.next;

                if (curr.data > next.data) {
                    int val = curr.data;
                    curr.data = next.data;
                    next.data = val;
                }
            }
            temp = temp.next;
            flag = !flag;
        }
        return head;
    }
}
