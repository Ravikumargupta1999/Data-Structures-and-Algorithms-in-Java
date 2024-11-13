public class Maximum_difference_between_node_and_its_ancestor {
    // https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&category[]=Tree&query=company[]Amazondifficulty[]1page2company[]Amazoncategory[]Tree
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    int difference = Integer.MIN_VALUE;
    public int maxDiff(Node root) {
        helper(root);
        return difference;
    }
    public int[] helper(Node root)
    {
        if(root == null)
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        if(root.left == null && root.right == null)
            return new int[]{root.data,root.data};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int min = Math.min(left[0],right[0]);
        int max = Math.max(left[1],right[1]);
        difference = Math.max(difference,Math.max(root.data-max,root.data-min));
        min = Math.min(min,root.data);
        max = Math.max(max,root.data);
        return new int[]{min,max};
    }
}
