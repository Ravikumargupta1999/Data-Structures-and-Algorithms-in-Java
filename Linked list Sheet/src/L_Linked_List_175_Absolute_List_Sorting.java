import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/absolute-list-sorting/1/?category[]=Linked%20List&category[]=Linked%20List&page=1&query=category[]Linked%20Listpage1category[]Linked%20List

public class L_Linked_List_175_Absolute_List_Sorting {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // TC : O(N)
    // SC : O(n)
    static Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Node temp = head;
        while (temp.next != null) {
            priorityQueue.add(temp.data);
            temp = temp.next;
        }
        priorityQueue.add(temp.data);
        System.out.println(priorityQueue);

        head = new Node(priorityQueue.poll());
        temp = head;
        while (!priorityQueue.isEmpty()) {
            temp.next = new Node(priorityQueue.poll());
            temp = temp.next;
        }

        return head;
    }

    Node sortList1(Node head) {


        Node lessThanZero = new Node(-1);
        Node greaterThanZero = new Node(-1);

        Node lesser = lessThanZero;
        Node greater = greaterThanZero;

        Node curr = head;

        while (curr != null) {
            if (curr.data < 0) {
                lesser.next = curr;
                lesser = lesser.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        greater.next = null;
        lesser.next = null;

        if(lessThanZero.next == null)
            return greaterThanZero;

        Node reversed = reverse(lessThanZero.next);

        Node temp = reversed;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = greaterThanZero.next;
        return reversed;
    }
    Node reverse(Node node){
        if(node == null)
            return null;
        Node curr = node;
        Node prev = null;

        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
