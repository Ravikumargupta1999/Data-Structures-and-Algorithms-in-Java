import javafx.util.Pair;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=4&query=company[]Amazondifficulty[]0page4company[]Amazon#

public class Top_K_Frequent_Elements {
    class Pair {
        int val;
        int count;

        public Pair(int val, int count) {
            this.count = count;
            this.val = val;
        }
    }
    // Accepted on Leet code but not on GFG
//https://leetcode.com/problems/top-k-frequent-elements/submissions/

    public int[] topK(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(mp.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue())
                    return o2.getKey() - o1.getKey();
                else
                    return o2.getValue()
                            - o1.getValue();
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = list.get(i).getKey();
        return res;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}