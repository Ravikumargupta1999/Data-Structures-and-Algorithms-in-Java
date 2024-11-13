import java.util.Collections;
import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1/?category[]=Linked%20List&category[]=Linked%20List&page=1&query=category[]Linked%20Listpage1category[]Linked%20List

public class L_Linked_List_151_Merge_2_Sorted_Linked_List {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node mergeResult(Node node1, Node node2) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Node temp = node1;
        while (temp != null) {
            priorityQueue.add(temp.data);
            temp = temp.next;
        }
        temp = node2;
        while (temp != null) {
            priorityQueue.add(temp.data);
            temp = temp.next;
        }
        System.out.println(priorityQueue);

        Node head = new Node(priorityQueue.poll());
        temp = head;
        while (!priorityQueue.isEmpty()) {
            temp.next = new Node(priorityQueue.poll());
            temp = temp.next;
        }

        return head;
    }
}
