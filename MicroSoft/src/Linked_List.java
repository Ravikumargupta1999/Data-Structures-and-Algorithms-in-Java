public class Linked_List {
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        Node res = new Node();
        res.data = -1;
        Node temp = res;
        for (int i = 0; i < 9; i++) {
            temp.next = new Node();
            temp.next.data = i;
            temp = temp.next;
        }
        res = res.next;
        while (res != null) {
            System.out.print(res.data+"  ");
            res = res.next;
        }

    }
}
