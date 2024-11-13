public class BT_196_6_Construct_Binary_Search_Tree_From_Inorder_Traversal {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    //https://www.youtube.com/watch?v=UAsLKuEMhsQ&list=PL-Jc9J83PIiHgjQ9wfJ8w-rXU368xNX4L&index=15
    public static TreeNode constructFromInOrder(int[] inOrder) {
       if(inOrder.length == 0)
           return null;
       if(inOrder.length == 1)
           return new TreeNode(inOrder[0]);
       return constructTree(inOrder,0,inOrder.length-1);
    }
    public static TreeNode constructTree(int[] inorder,int start,int end)
    {
        if( start > end)
            return null;
        if( start == end)
            return new TreeNode(inorder[start]);
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(inorder[mid]);
        root.left = constructTree(inorder,start,mid-1);
        root.right = constructTree(inorder,mid+1,end);
        return root;
    }

}
