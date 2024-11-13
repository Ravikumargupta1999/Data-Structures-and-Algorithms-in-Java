package Day_17_Binary_Search_;

import java.util.ArrayList;
import java.util.Arrays;

public class Path_to_Given_Node {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    // https://www.interviewbit.com/problems/path-to-given-node/
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        findPath(A,B,list);
        return list;
    }
    public boolean findPath(TreeNode A,int B,ArrayList<Integer> list){
        if(A == null)
            return false;
        list.add(A.val);
        if(A.val == B)
            return true;
        if(findPath(A.left,B,list))
            return true;
        if(findPath(A.right,B,list))
            return true;
        list.remove(list.size()-1);
        return false;
    }
}
