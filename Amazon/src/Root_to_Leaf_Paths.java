import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=4&query=company[]Amazondifficulty[]0company[]Amazonpage4#

public class Root_to_Leaf_Paths {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        ArrayList<Integer> ans = new ArrayList<>();
        Function(root,result,ans);
        return result;
    }
    public static void Function(Node root,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> al)
    {
        if(root == null)
            return;
        al.add(root.data);
        if(root.left == null && root.right == null)
        {
            result.add(al);
            return;
        }
        Function(root.left,result,al);
        Function(root.right,result,al);
        //return;
    }
}
