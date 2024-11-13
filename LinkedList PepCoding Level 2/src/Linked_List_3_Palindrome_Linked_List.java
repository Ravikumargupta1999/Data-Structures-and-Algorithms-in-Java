import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Linked_List_3_Palindrome_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.next.next == null)
            return head.val == head.next.val;

        ListNode midNode = getMidNode(head);
        ListNode newNode = reverse(midNode.next);

        midNode.next = null;


        while (head != null && newNode != null) {
            if (head.val != newNode.val)
                return false;
            newNode = newNode.next;
            head = head.next;
        }
        return true;
    }

    public ListNode getMidNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;
        if (head.next.next == null)
            return head.data == head.next.data;

        Node midNode = getMidNodeOFLinkedList(head);
        Node newNode = reverseNode(midNode.next);

        midNode.next = null;


        while (head != null && newNode != null) {
            if (head.data != newNode.data)
                return false;
            newNode = newNode.next;
            head = head.next;
        }
        return true;
    }

    public Node getMidNodeOFLinkedList(Node node) {
        Node slow = node;
        Node fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverseNode(Node node) {
        Node curr = node;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
//1
//        8 3
//        abbabaab
//        6 3 5 1 4 2 7 8
//        1 3
//        4 7
//        3 5