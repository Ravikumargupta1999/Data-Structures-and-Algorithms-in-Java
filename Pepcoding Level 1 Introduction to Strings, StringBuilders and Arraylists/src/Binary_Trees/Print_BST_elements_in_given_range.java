package Binary_Trees;

import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/print-bst-elements-in-given-range/1#
public class Print_BST_elements_in_given_range {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        traversal(root,arrayList,low,high);
        return arrayList;
    }
    public static void traversal(Node root,ArrayList<Integer> al,int low ,int high)
    {
        if(root == null)
            return;
        traversal(root.left,al,low,high);
        if(root.data >= low && root.data <=high)
        {
            al.add(root.data);
        }
        traversal(root.right,al,low,high);
    }


}
