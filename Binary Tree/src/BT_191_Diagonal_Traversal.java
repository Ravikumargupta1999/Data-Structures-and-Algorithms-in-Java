//import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BT_191_Diagonal_Traversal {
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

    // https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1/
    public ArrayList<Integer> diagonal(Node root)
    {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        for (int i = 0; i < al.size(); i++)
            al.add(new ArrayList<>());
        if (root == null)
            return al1;


        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0) {
            int size = q.size();
            ArrayList<Integer> ans = new ArrayList<>();
            while (size-- > 0) {
                Node temp = q.poll();
                while (temp != null) {
                    ans.add(temp.data);
                    if (temp.left != null)
                        q.add(temp.left);
                    temp = temp.right;
                }
            }
            al.add(ans);
        }

        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                al1.add(al.get(i).get(j));
            }

        }
        return al1;
    }


}
