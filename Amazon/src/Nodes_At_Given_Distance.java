import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1#
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class Nodes_At_Given_Distance {
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
    public static ArrayList<Integer> distancek(Node root,int target,int k)
    {
        ArrayList<Integer> al = new ArrayList<>();
        distancek(root,target,k,al);
        return al;
    }
    public static int distancek(Node root,int target,int k,ArrayList<Integer> ans)
    {
        if(root == null)
            return -1;
        if(root.data == target)
        {
            kdown(root,k-0,null,ans);
            return 1;
        }
        int ld = distancek(root.left,target,k,ans);
        if(ld != -1)
        {
            kdown(root,k-ld,root.left,ans);
            return ld+1;
        }
        int rd = distancek(root.right,target,k,ans);
        if(rd != -1)
        {
            kdown(root,k-rd,root.right,ans);
            return rd+1;
        }
        return -1;
    }
    public static void kdown(Node root,int k,Node blockNode,ArrayList<Integer> ans)
    {
        if(root == null || k < 0 || root == blockNode)
            return;

        if(k == 0)
        {
            ans.add(root.data);
            return;
        }
        kdown(root.left,k-1,blockNode,ans);
        kdown(root.right,k-1,blockNode,ans);
    }

}
