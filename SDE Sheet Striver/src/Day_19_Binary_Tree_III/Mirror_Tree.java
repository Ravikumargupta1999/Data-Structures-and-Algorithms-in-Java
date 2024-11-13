package Day_19_Binary_Tree_III;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
public class Mirror_Tree {
    // https://practice.geeksforgeeks.org/problems/mirror-tree/1
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    void mirror(Node node) {
        node = mirror1(node);
    }
    Node mirror1(Node node) {
        if(node == null)
            return null;
        Node left = mirror1(node.left);
        Node right = mirror1(node.right);
        node.left = right;
        node.right = left;
        return node;

    }
}
