package Day3;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/path-sum-ii/submissions/
public class Path_Sum_II {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        getLeafNodeSum(root,0,targetSum,temp,list);
        return list;
    }
    public void getLeafNodeSum(TreeNode root,int sum,int targetSum,List<Integer> list,List<List<Integer>> res){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(sum + root.val == targetSum){
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(root.val);
                res.add(newList);
            }
            return;
        }
        list.add(root.val);
        getLeafNodeSum(root.left,sum+root.val,targetSum,list,res);
        getLeafNodeSum(root.right,sum+root.val,targetSum,list,res);
        list.remove(list.size()-1);
    }
}
