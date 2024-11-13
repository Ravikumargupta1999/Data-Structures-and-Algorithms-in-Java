public class L_Linked_List_167_Sort_List_Containing_0_1_2 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node sort(Node head) {
        Node temp = head;
        int[] arr = new int[3];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 0;
        while (temp != null) {
            if (temp.data == 0)
                arr[0] = arr[0] + 1;
            else if (temp.data == 1)
                arr[1] = arr[1] + 1;
            else
                arr[2] = arr[2] + 1;
            temp = temp.next;
        }
        temp = head;
        while (arr[0] > 0) {
            temp.data = 0;
            arr[0]--;
            temp = temp.next;
        }
        while (arr[1] > 0) {
            temp.data = 1;
            arr[1]--;
            temp = temp.next;
        }
        while (arr[2] > 0) {
            temp.data = 2;
            arr[2]--;
            temp = temp.next;
        }

        return head;
    }

    // Method 2
    static Node segregate(Node head) {
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);

        Node c0 = dummy0;
        Node c1 = dummy1;
        Node c2 = dummy2;

        Node c = head;

        while (c != null) {
            if (c.data == 0) {
                c0.next = c;
                c0 = c0.next;
            } else if (c.data == 1) {
                c1.next = c;
                c1 = c1.next;
            } else {
                c2.next = c;
                c2 = c2.next;
            }
            c = c.next;
        }

        c2.next = null;
        c1.next = dummy2.next;
        c0.next = dummy1.next;

        return dummy0.next;
    }
}
