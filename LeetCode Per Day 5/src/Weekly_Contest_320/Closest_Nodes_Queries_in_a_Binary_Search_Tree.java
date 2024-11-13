package Weekly_Contest_320;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Closest_Nodes_Queries_in_a_Binary_Search_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        for (int val : queries) {
            List<Integer> list = new ArrayList<>();
            list.add(searchMin(arr, val));
            list.add(searchMax(arr, val));
            res.add(list);
        }
        return res;
    }

    void inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public int searchMin(ArrayList<Integer> list, int val) {
        int l = 0;
        int r = list.size() - 1;
        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) == val) {
                return list.get(mid);
            } else if (list.get(mid) < val) {
                res = list.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public int searchMax(ArrayList<Integer> list, int val) {
        int l = 0;
        int r = list.size() - 1;
        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) == val) {
                return list.get(mid);
            } else if (list.get(mid) < val) {
                l = mid + 1;
            } else {
                res = list.get(mid);
                r = mid - 1;
            }
        }
        return res;
    }
}
