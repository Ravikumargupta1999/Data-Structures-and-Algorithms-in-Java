import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1/?category[]=Tree&category[]=Tree&difficulty[]=2&page=1&query=category[]Treedifficulty[]2page1category[]Tree

public class BST_224_Merge_Two_BST {
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // Method - 1
    public List<Integer> merge1(Node root1, Node root2) {
        ArrayList<Integer> al1 = Inorder(root1);
        ArrayList<Integer> al2 = Inorder(root2);
        System.out.println(al1);
        System.out.println(al2);
        List<Integer> al = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < al1.size() && j < al2.size())
            if(al1.get(i) < al2.get(j))
                al.add(al1.get(i++));
            else
                al.add(al2.get(j++));
        while (i < al1.size())
            al.add(al1.get(i++));
        while (j < al2.size())
            al.add(al1.get(j++));
        return al;

    }
    public static ArrayList<Integer> Inorder(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                al.add(current.data);
                current = current.right;
            }
            else {

                Node predecessor = current.left;

                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    predecessor.right = null;
                    al.add(current.data);
                    current = current.right;
                }
            }
        }
        return al;
    }



    // Method - 2

    public List<Integer> merge2(Node root1, Node root2) {
        List<Integer> al1 = new ArrayList<>();
        Inorder(root1, al1);
        int[] arr1 = new int[al1.size()];
        for (int i = 0; i < al1.size(); i++) {
            arr1[i] = al1.get(i);
        }

        List<Integer> al2 = new ArrayList<>();
        Inorder(root2, al2);
        int[] arr2 = new int[al2.size()];
        for (int i = 0; i < al2.size(); i++) {
            arr2[i] = al2.get(i);
        }


        int[] new_arr = Merge_two_Sorted_Array(arr1, arr2);
        Node temp_root = Array_To_B_BST(new_arr, 0, new_arr.length - 1);
        List<Integer> al = new ArrayList<>();
        Inorder(temp_root, al);
        return al;

    }

    public int[] Merge_two_Sorted_Array(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < m) {
            if (arr1[i] >= arr2[j]) {
                int temp = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = temp;
                i--;
                j++;
            } else
                break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] arr3 = new int[n + m];
        int l = 0;
        int p = 0;
        while (l < n) {
            arr3[l] = arr1[l];
            l++;
            p++;
        }

        int s = 0;
        while (s < m) {
            arr3[p] = arr2[s];
            p++;
            s++;
        }
        return arr3;
    }


    public Node Array_To_B_BST(int[] al, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(al[mid]);
        node.left = Array_To_B_BST(al, start, mid - 1);
        node.right = Array_To_B_BST(al, mid + 1, end);

        return node;
    }

    public void Inorder(Node root, List<Integer> al) {
        if (root == null)
            return;
        Inorder(root.left, al);
        al.add(root.data);
        Inorder(root.right, al);
    }


    // Method - 3

    public List<Integer> merge(Node root1, Node root2) {
        List<java.lang.Integer> al1 = inorder(root1);
        List<java.lang.Integer> al2 = inorder(root2);
        return mergeTwoSortedArray(al1, al2);
    }

    public List<Integer> inorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                list.add(root.data);
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> mergeTwoSortedArray(List<Integer> l1, List<Integer> l2) {
        List<Integer> l = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j))
                l.add(l1.get(i++));
            else if (l1.get(i) > l2.get(j))
                l.add(l2.get(j++));
            else
                l.add(l2.get(j++));
        }
        while (i < l1.size())
            l.add(l1.get(i++));
        while (j < l2.size())
            l.add(l2.get(j++));
        return l;
    }
}
