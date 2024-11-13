// https://practice.geeksforgeeks.org/problems/leaves-to-dll/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Linked%20List&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Linked%20List#

import java.util.*;

public class Leaves_to_DLL {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node convertToDLL(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        collectNodes(root, al);
        if (al.size() == 0)
            return null;
        Node dll = new Node(al.get(0));
        Node temp = dll;
        if (al.size() == 1) {
            dll.left = null;
            dll.right = null;
            return dll;
        }
        for (int i = 1; i < al.size(); i++) {
            temp.right = new Node(al.get(i));
            temp.right.left = temp;
            temp = temp.right;
        }
        return dll;
    }

    public static void collectNodes(Node root, ArrayList<Integer> al) {
        if (root == null)
            return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            al.add(root.left.data);
            root.left = null;

        }
        if (root.right != null && root.right.left == null && root.right.right == null) {
            al.add(root.right.data);
            root.right = null;
        }
        collectNodes(root.left, al);
        collectNodes(root.right, al);
    }

    static ArrayList<Integer> iterative_Inorder(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                al.add(root.data);
                root = root.right;
            }
        }
        return al;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
//        node.left.right = new Node(5);
//        node.right.left = new Node(6);
//        node.right.right = new Node(7);
//        Node root =  convertToDLL(node);
//        Node temp = root;
//        while (temp.right != null)
//        {
//            System.out.print(temp.data+"  ");
//            temp = temp.right;
//        }
//        System.out.println(temp.data);
//        while (temp.left != null)
//        {
//            System.out.print(temp.data+"  ");
//            temp = temp.left;
//        }
//        System.out.println(temp.data);


        Node head = convertToDLL(node);

        ArrayList<Integer> res = iterative_Inorder(node);
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
        System.out.println("");
        Node curr = head;
        Node last = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            last = curr;
            curr = curr.right;
        }
        System.out.println();
        curr = last;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.left;
        }
        System.out.println();
    }
}
