import java.util.ArrayList;
import java.util.HashMap;

public class Check_Mirror_in_N_ary_tree {
    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static int checkMirrorTree(int n, int e, int[] arr1, int[] arr2) {
        Node root1 = createTree(arr1);
        Node root2 = createTree(arr2);
        // Inorder(root1);
        // System.out.println();
        // Inorder(root2);
        // System.out.println();
        return isMirrorTree(root1,root2) ? 1 : 0;
    }
    static boolean isMirrorTree(Node root1,Node root2)
    {
        if(root1 == null || root2 == null)
        {
            return root1 == root2 ? true : false;
        }
        if(root1.data != root2.data)
            return false;
        return isMirrorTree(root1.left,root2.right) && isMirrorTree(root1.right,root2.left);
    }
    public static Node createTree(int parent[]) {
        if (parent.length == 0)
            return null;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < parent.length; i+=2) {
            if (map.containsKey(parent[i])) {
                map.get(parent[i]).add(parent[i+1]);
            } else {
                map.put(parent[i], new ArrayList<>());
                map.get(parent[i]).add(parent[i+1]);
            }
        }
        Node root = new Node(parent[0]);
        makeTree(root, map);
        return root;
    }
    public static void makeTree(Node root, HashMap<Integer, ArrayList<Integer>> map) {
        if (!map.containsKey(root.data))
            return;
        ArrayList<Integer> al = map.get(root.data);
        if (al.size() == 1) {
            root.left = new Node(al.get(0));
            makeTree(root.left, map);
        } else if (al.size() == 2) {
            root.left = new Node(al.get(0));
            makeTree(root.left, map);
            root.right = new Node(al.get(1));
            makeTree(root.right, map);
        }
    }
    public static void Inorder(Node root) {
        if (root == null)
            return;
        Inorder(root.left);
        System.out.print(root.data + "   ");
        Inorder(root.right);
    }


}
