public class Linked_List_23_Subtraction_in_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/subtraction-in-linked-list/1


    static Node subLinkedList(Node l1, Node l2) {

        // If either of linked list is empty then return
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        // Code for removing trailing zero from list 1
        Node temp1 = l1;
        while (temp1 != null) {
            if (temp1.data != 0) {
                l1 = temp1;
                break;
            }
            temp1 = temp1.next;
        }

        // // Code for removing trailing zero from list 2
        temp1 = l2;
        while (temp1 != null) {
            if (temp1.data != 0) {
                l2 = temp1;
                break;
            }
            temp1 = temp1.next;
        }

        // Size of both linked list
        int n1 = size(l1);
        int n2 = size(l2);

        // if l2 is larger make l1 larger
        if (n1 < n2) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        // Do nothing if list1 is larger
        else if (n2 < n1) {

        }
        // if length of both lists are equal then make sure list1 should be larger in value
        else {
            Node c1 = l1;
            Node c2 = l2;
            while (c1 != null) {
                if (c1.data > c2.data) {
                    break;
                } else if (c2.data > c1.data) {
                    Node temp = l1;
                    l1 = l2;
                    l2 = temp;
                    break;
                }
                c1 = c1.next;
                c2 = c2.next;
            }
            if (c1 == null && c2 == null)
                return new Node(0);
        }
        // till here we have make sure list1 is larger in value and none list consist of trailing zeros

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        Node dummy = new Node(-1);

        Node prev = dummy;

        Node c1 = l1;
        Node c2 = l2;

        int rem = 0;

        while (l1 != null) {
            int c = 0;
            int a = l1.data;
            int b = l2 != null ? l2.data : 0;

            // Before subtracting we need to make sure reminder is balanced
            if (rem < 0) {
                if (a == 0) {
                    a = 9;
                    rem = -1;
                } else {
                    a = a + rem;
                    rem = 0;
                }
            }

            // Subtraction of a & b with different possible value of a and b
            if (a == 0 && b == 0) {
                c = 0;
            } else if (a == b) {
                c = 0;
            } else if (a > b) {
                c = a - b;
            } else if (a < b) {
                a = 10 + a;
                c = a - b;
                rem = -1;
            }
            l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            prev.next = new Node(c);
            prev = prev.next;
        }

        Node temp = reverseList(dummy.next);
        while (temp != null) {
            if (temp.data != 0)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        Node forw = head.next;
        Node prev = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    static int size(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }


}
