import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/cousins-of-a-given-node/1/?difficulty[]=1&page=3&company[]=Amazon&company[]=Microsoft&company[]=Google&company[]=Adobe&company[]=Flipkart&company[]=Goldman%20Sachs&category[]=Tree&query=difficulty[]1page3company[]Amazoncompany[]Microsoftcompany[]Googlecompany[]Adobecompany[]Flipkartcompany[]Goldman%20Sachscategory[]Tree#
public class Cousins_of_a_given_node {
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

    public static ArrayList<Integer> printCousins(Node root, Node node_to_find) {

        if (root == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(-1);
            return arrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean found = false;
            while (n > 0) {
                boolean local = false;
                Node node = queue.poll();
                System.out.println(node.data);
                if (node.left != null) {
                    System.out.println("Hey left ");
                    if (node.left == node_to_find) {
                        System.out.println("Hey left "+node.left.data);
                        local = true;
                        found = true;
                    }
                    queue.add(node.left);
                }
                if (node.right != null) {
                    System.out.println("Hey right ");
                    if (node.right == node_to_find) {
                        System.out.println("Hey right "+node.right.data);
                        local = true;
                        found = true;
                    }
                    queue.add(node.right);
                }
                if (!local) {
                    if (node.left != null) {
                        arrayList.add(node.left.data);
                    }
                    if (node.right != null) {
                        arrayList.add(node.right.data);
                    }
                }
                n--;
            }
            System.out.println(arrayList);
            if (found) {
                break;
            } else {
                arrayList.clear();
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(-1);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(printCousins(root,root.left.right));
    }

}
