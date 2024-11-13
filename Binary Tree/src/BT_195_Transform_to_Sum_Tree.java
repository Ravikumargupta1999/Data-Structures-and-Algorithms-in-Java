import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT_195_Transform_to_Sum_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
    public static void toSumTree(Node root){
        sum(root);

    }
    public static int sum(Node root)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            int temp = root.data;
            root.data = 0;
            return temp;
        }
        int temp = root.data;
        int sum = 0;
        if (root.left != null) {
            sum += sum(root.left);
        }
        if(root.right != null)
        {
            sum += sum(root.right);
        }
        root.data = sum;
        return sum + temp;
    }

    public void toSumTree1(Node root){
        transFormToSumTree(root);
    }
    public int transFormToSumTree(Node root){
        if(root == null)
            return 0;
        int a = transFormToSumTree(root.left);
        int b = transFormToSumTree(root.right);

        int c = root.data;

        root.data = a + b;

        return a + b + c;
    }

    public void toSumTree2(Node root){
        sumTree2(root);
    }
    public int sumTree2(Node root){
        if(root == null){
            return 0;
        }

        int total = root.data;

        int left = sumTree2(root.left);

        int right = sumTree2(root.right);

        root.data = left + right;

        return total + left + right;
    }

}
