import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/print-nodes-having-k-leaves/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&category[]=Tree&query=company[]Amazondifficulty[]1page2company[]Amazoncategory[]Tree#
public class Print_Nodes_having_K_leaves {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> btWithKleaves(Node root, int k) {
        findNodes(root, k);
        if(arrayList.size() == 0)
        {
            arrayList.add(-1);
        }
        return arrayList;
    }

    public int findNodes(Node root, int k) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        int leftCount = findNodes(root.left, k);
        int rightCount = findNodes(root.right, k);
        if (leftCount + rightCount == k) {
            arrayList.add(root.data);
        }
        return leftCount + rightCount;
    }
}
