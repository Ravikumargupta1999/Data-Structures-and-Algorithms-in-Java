public class Binary_Tree_Maximum_Path_Sum {
    class Node {

        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    class Res
    {
        int val;
    }

    int findMaxSum(Node node)
    {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        solve(node, res);
        return res.val;
    }
    int solve(Node node,Res res)
    {
        if (node == null)
            return 0;
        int l = solve(node.left, res);
        int r = solve(node.right, res);
        int temp = Math.max(l, r) + node.data;
        if(node.left == null && node.right == null)
            temp = Math.max(temp,node.data);
        int ans = Math.max(temp, l + r + node.data);
        res.val = Math.max(res.val, ans);
        return temp;
    }

    public static void main(String[] args) {

    }

}
