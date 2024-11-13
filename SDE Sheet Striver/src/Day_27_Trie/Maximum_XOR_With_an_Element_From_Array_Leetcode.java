package Day_27_Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// https://leetcode.com/problems/maximum-xor-with-an-element-from-array/submissions/
// https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=8
public class Maximum_XOR_With_an_Element_From_Array_Leetcode {

    static class Node {
        Node links[] = new Node[2];

        public Node() {
        }

        boolean containsKey(int ind) {
            return (links[ind] != null);
        }

        Node get(int ind) {
            return links[ind];
        }

        void put(int ind, Node node) {
            links[ind] = node;
        }
    }

    static class Trie {
        private static Node root;

        //Initialize your data structure here

        Trie() {
            root = new Node();
        }


        //Inserts a word into the trie

        public static void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        public int getMax(int num) {
            Node node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxNum = maxNum | (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return maxNum;
        }
    }


    public int[] maximizeXor(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        int m = queries.length;
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlineQueries.add(temp);
        }
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
        int ind = 0;
        int n = arr.length;
        Trie trie = new Trie();
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        for (int i = 0; i < m; i++) {
            while (ind < n && arr[ind] <= offlineQueries.get(i).get(0)) {
                trie.insert(arr[ind]);
                ind++;
            }
            int queryInd = offlineQueries.get(i).get(2);
            if (ind != 0)
                ans[queryInd] = trie.getMax(offlineQueries.get(i).get(1));
            else
                ans[queryInd] = -1;
        }
        return ans;
    }

}
