public class L_Linked_List_178_Subtraction_in_Linked_List {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node subLinkedList(Node l1, Node l2) {
        String str1 = "";
        Node temp1 = l1;
        while (temp1 != null) {
            str1 = str1 + temp1.data;
            temp1 = temp1.next;
        }

        String str2 = "";
        Node temp2 = l1;
        while (temp2 != null) {
            str2 = str2 + temp2.data;
            temp2 = temp2.next;
        }

        int i1 = Integer.parseInt(str1);
        int i2 = Integer.parseInt(str2);

        int i = Math.abs(i1 - i2);

        String str = Integer.toString(i);
        str1 = "" + str.charAt(0);
        int val = Integer.parseInt(str1);
        Node heap = new Node(val);
        Node temp = heap;
        int l = 1;
        while (l < str.length()) {
            str1 = "" + str.charAt(l);
            int val1 = Integer.parseInt(str1);
            temp.next = new Node(val1);
            temp = temp1.next;
        }
        return heap;
    }
}
