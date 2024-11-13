import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1

public class A_Trie_407_Unique_rows_in_boolean_matrix {
    static class TrieNode {
        TrieNode[] arr = new TrieNode[2];
        boolean isEnd = false;
        int count = 0;
    }

    public static ArrayList<ArrayList<Integer>> uniqueRow(int[][] matrix, int r, int c) {
        TrieNode root = new TrieNode();
        for (int[] arr : matrix) {
            insert(root, arr);
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // DFS also gives right solution but in order of matrix
        // DFS(root, res, new ArrayList<>());

        for (int[] arr : matrix) {
            if (search(root, arr)) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int val : arr)
                    temp.add(val);
                res.add(temp);
            }
        }
        return res;
    }

    public static void DFS(TrieNode node, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arrayList) {
        if (node.isEnd) {
            res.add(new ArrayList<>(arrayList));
            return;
        }
        if (node.arr[0] != null) {
            arrayList.add(0);
            DFS(node.arr[0], res, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
        if (node.arr[1] != null) {
            arrayList.add(1);
            DFS(node.arr[1], res, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static void insert(TrieNode node, int[] arr) {
        TrieNode curr = node;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (curr.arr[0] == null)
                    curr.arr[0] = new TrieNode();
                curr = curr.arr[0];
            }
            if (arr[i] == 1) {
                if (curr.arr[1] == null)
                    curr.arr[1] = new TrieNode();
                curr = curr.arr[1];
            }
        }
        curr.isEnd = true;
        curr.count++;
    }

    public static boolean search(TrieNode node, int[] arr) {
        TrieNode curr = node;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                curr = curr.arr[0];
            else
                curr = curr.arr[1];
        }
        boolean ans = curr.isEnd;
        curr.isEnd = false;
        return ans;
    }


    public static ArrayList<ArrayList<Integer>> uniqueRow1(int a[][], int r, int c) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            al.add(new ArrayList<>());
        }
        int count = 0;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < r; i++) {
            String str = "";
            for (int j = 0; j < c; j++) {
                str = str + a[i][j];
            }
            if (set.contains(str) == false) {
                set.add(str);
                for (int l = 0; l < str.length(); l++) {
                    al.get(count).add(Integer.parseInt("" + str.charAt(l)));
                }
                count++;

            }
        }
        for (int i = al.size() - 1; i >= 0; i--) {
            if (al.get(i).isEmpty())
                al.remove(i);
        }
        return al;
    }


}
