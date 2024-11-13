// https://practice.geeksforgeeks.org/problems/node-at-distance/1/?difficulty[]=1&page=2&company[]=Amazon&company[]=Microsoft&company[]=Google&company[]=Adobe&company[]=Flipkart&company[]=Goldman%20Sachs&category[]=Tree&query=difficulty[]1page2company[]Amazoncompany[]Microsoftcompany[]Googlecompany[]Adobecompany[]Flipkartcompany[]Goldman%20Sachscategory[]Tree#
public class BT_217_Node_at_distance {
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    int ans = 0;
    int[] arr;
    boolean[] set;

    int printKDistantFromLeaf(Node root, int k) {
        arr = new int[10000 + 1];
        set = new boolean[10000+1];
        getNodes(root, k, 0);
        return ans;
    }

    public void getNodes(Node root, int k, int count) {
        if (root == null)
            return;
        arr[count] = root.data;
        set[count] = false;
        if (root.left == null && root.right == null && count - k >= 0 && !set[count-k]) {
            set[count-k] = true;
            ans++;
        }
        getNodes(root.left, k, count+1);
        getNodes(root.right, k, count+1);
    }
}
