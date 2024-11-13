import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&query=company[]Amazondifficulty[]1page2company[]Amazon#

public class Tree_from_Postorder_and_Inorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    static HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
    static int index;

    static Node buildTree(int in[], int post[], int len) {
        for (int i = 0; i < len; i++)
            mp.put(in[i], i);
        index = len - 1;
        return buildUtil(in, post, 0, len - 1);
    }

    static Node buildUtil(int in[], int post[],
                          int inStrt, int inEnd) {

        // Base case
        if (inStrt > inEnd)
            return null;
        int curr = post[index];
        Node node = new Node(curr);
        (index)--;
        if (inStrt == inEnd)
            return node;

        int iIndex = mp.get(curr);
        System.out.println(inStrt+"  "+inEnd);
        node.right = buildUtil(in, post, iIndex + 1,
                inEnd);
        node.left = buildUtil(in, post, inStrt,
                iIndex - 1);
        return node;
    }


//    //Function to return a tree created from postorder and inoreder traversals.
//    static Node buildTree(int in[], int post[], int n) {
//        int start = 0;
//        int end = in.length - 1;
//        int mid = start + (end - start) / 2;
//        if ((end - start + 1) % 2 == 0) {
//            mid = mid + 1;
//        }
//        Node temp = new Node(in[mid]);
//        temp.left = tree(temp.left, start, mid - 1, in, true);
//        System.out.println("");
//        temp.right = tree(temp.right, mid + 1, end, in, false);
//        return temp;
//    }
//
//    public static Node tree(Node root, int start, int end, int[] arr, boolean flag) {
//        if (start > end)
//            return null;
//        int mid = start + (end - start) / 2;
//        if (!flag) {
//            if ((end - start + 1) % 2 == 0) {
//                mid = mid + 1;
//            }
//        }
//        else if(end-start + 1 > 2)
//        {
//            if ((end - start + 1) % 2 == 0) {
//                mid = mid + 1;
//            }
//        }
////        System.out.println(start+"  "+end+"    "+arr[start]+"   "+arr[end]+"   "+mid+"  "+arr[mid]);
//        root = new Node(arr[mid]);
//        root.left = tree(root.left, start, mid - 1, arr, true);
//        root.right = tree(root.right, mid + 1, end, arr, false);
//        return root;
//    }
//
    static void Preorder(Node root, List<Integer> al) {
        if (root == null)
            return;
        al.add(root.data);
        Preorder(root.left, al);
        Preorder(root.right, al);
    }

    public static void main(String[] args) {
        int[] arr = {};
        int start = 0;
        int end = 1;

        int mid = start + (end - start) / 2;

        if ((end - start + 1) % 2 == 0) {
            mid = mid + 1;
        }
        System.out.println(mid);

        Node temp = buildTree(arr, arr, arr.length);
        List<Integer> al = new ArrayList<Integer>();
        Preorder(temp,al);
        System.out.println(al);
    }


}
