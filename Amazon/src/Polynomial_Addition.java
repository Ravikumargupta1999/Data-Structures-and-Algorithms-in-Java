public class Polynomial_Addition {
    static class Node {
        int coeff;
        int pow;
        Node next;

        Node(int a, int b) {
            coeff = a;
            pow = b;
            next = null;
        }
    }

    public static Node addPolynomial(Node p1, Node p2) {

        Node head = new Node(-1, -1);
        Node a = p1;
        Node b = p2;
        Node res = head;
        while (a != null || b != null) {
            if (a == null) {
                res.next = b;
                break;
            } else if (b == null) {
                res.next = a;
                break;
            } else if (a.pow == b.pow) {
                res.next = new Node(b.coeff + a.coeff, a.pow);
                a = a.next;
                b = b.next;
            } else if (a.pow > b.pow) {
                res.next = new Node(a.coeff, a.pow);
                a = a.next;
            } else if (a.pow < b.pow) {
                res.next = new Node(b.coeff, b.pow);
                b = b.next;
            }

            res = res.next;
        }

        return head.next;

    }

    public static void main(String[] args) {

    }
}
