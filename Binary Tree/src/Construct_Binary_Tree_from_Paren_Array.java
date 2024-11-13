import java.util.ArrayList;
import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-parent-array/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
public class Construct_Binary_Tree_from_Paren_Array {
    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }
    public static Node createTree(int parent[], int N) {
        if (parent.length == 0)
            return null;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            if (map.containsKey(parent[i])) {
                map.get(parent[i]).add(i);
            } else {
                map.put(parent[i], new ArrayList<>());
                map.get(parent[i]).add(i);
            }
        }
        Node root = new Node(map.get(-1).get(0));
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

}
