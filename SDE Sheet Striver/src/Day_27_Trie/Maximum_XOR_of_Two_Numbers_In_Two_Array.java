package Day_27_Trie;

import java.util.*;

public class Maximum_XOR_of_Two_Numbers_In_Two_Array {
    //https://www.codingninjas.com/codestudio/problems/maximum-xor_973113?leftPanelTab=1
    // https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=7

    static class Node {
        Node[] links = new Node[2];

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

    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(arr1.get(i));
        }
        int maxi = 0;
        for (int i = 0; i < m; i++) {
            maxi = Math.max(maxi, trie.getMax(arr2.get(i)));
        }
        return maxi;
    }

}
