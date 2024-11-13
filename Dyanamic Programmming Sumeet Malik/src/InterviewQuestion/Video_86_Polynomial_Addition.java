package InterviewQuestion;

public class Video_86_Polynomial_Addition {
    // https://practice.geeksforgeeks.org/problems/polynomial-addition/1
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
    public static Node addPolynomial(Node p1,Node p2)
    {
        Node res = new Node(-1, -1);

        Node temp = res;

        while (p1 != null || p2 != null) {

            if (p1 != null && p2 != null) {
                if (p1.pow == p2.pow) {
                    temp.next = new Node(p1.coeff + p2.coeff,p1.pow);
                    temp = temp.next;
                    p1 = p1.next;
                    p2 = p2.next;
                }else if(p1.pow > p2.pow){
                    temp.next = new Node(p1.coeff,p1.pow);
                    temp = temp.next;
                    p1 = p1.next;
                }else {
                    temp.next = new Node(p2.coeff,p2.pow);
                    temp = temp.next;
                    p2 = p2.next;
                }
            } else if (p1 != null) {
                temp.next = new Node(p1.coeff,p1.pow);
                temp = temp.next;
                p1 = p1.next;
            } else if (p2 != null) {
                temp.next = new Node(p2.coeff,p2.pow);
                temp = temp.next;
                p2 = p2.next;
            }
        }
        return res.next;

    }
}
