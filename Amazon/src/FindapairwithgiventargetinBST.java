import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
//https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=3&query=company[]Amazondifficulty[]1page3company[]Amazon

public class FindapairwithgiventargetinBST {
    class Node {
        int data;
        Node left;
        Node right;
        public Node(int d)
        {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public int isPairPresent(Node root, int target) {
        ArrayList<Integer> al = iterative_Inorder(root);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<al.size();i++)
        {
            int val = target - al.get(i);
            set.remove(al.get(i));
            if(set.contains(val))
                return 1;
            set.add(al.get(i));
        }
        return 0;
    }
    ArrayList<Integer> iterative_Inorder(Node root) {
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
