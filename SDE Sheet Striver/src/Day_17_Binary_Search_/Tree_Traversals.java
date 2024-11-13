package Day_17_Binary_Search_;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// https://www.youtube.com/watch?v=ySp2epYvgTE
// https://www.codingninjas.com/codestudio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
public class Tree_Traversals {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    static class pair {
        BinaryTreeNode<Integer> node;
        int num;

        public pair(BinaryTreeNode<Integer> node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        if (root == null)
            return null;

        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> po = new ArrayList<>();

        Stack<pair> stack = new Stack<>();
        stack.push(new pair(root, 1));

        while (!stack.isEmpty()) {
            pair rem = stack.pop();

            if (rem.num == 1) {
                pre.add(rem.node.data);
                rem.num++;
                stack.push(rem);

                if(rem.node.left != null){
                    stack.push(new pair(rem.node.left,1));
                }
            }else if (rem.num == 2) {
                in.add(rem.node.data);
                rem.num++;
                stack.push(rem);

                if(rem.node.right != null){
                    stack.push(new pair(rem.node.right,1));
                }
            }else {
                po.add(rem.node.data);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(in);
        list.add(pre);
        list.add(po);
        return list;
    }
}
