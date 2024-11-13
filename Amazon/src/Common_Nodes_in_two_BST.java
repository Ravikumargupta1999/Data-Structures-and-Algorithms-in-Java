import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
//https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=3&query=company[]Amazondifficulty[]0page3company[]Amazon

public class Common_Nodes_in_two_BST {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        ArrayList<Integer> al1 = iterative_Inorder(root1);
        ArrayList<Integer> al2 = iterative_Inorder(root2);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<al2.size();i++)
            set.add(al2.get(i));
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0;i<al1.size();i++)
            if(set.contains(al1.get(i)))
                res.add(al1.get(i));
        return res;
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
}
