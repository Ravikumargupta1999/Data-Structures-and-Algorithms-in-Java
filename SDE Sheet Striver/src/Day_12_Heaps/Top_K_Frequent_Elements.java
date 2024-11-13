package Day_12_Heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {

    // https://leetcode.com/problems/top-k-frequent-elements/submissions/
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums)
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return counts.get(b) - counts.get(a);
        });
        queue.addAll(counts.keySet());
        int[] res = new int[k];
        int i = 0;
        while (k-- > 0) {
            res[i++] = queue.poll();
        }
        return res;
    }
}
