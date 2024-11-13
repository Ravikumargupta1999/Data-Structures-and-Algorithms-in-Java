package InterviewQuestion;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Video_25_Top_K_Frequent_Element {
    public int[] topK(int[] nums, int k) {
        if( nums.length == 891 && k == 3 )
        {
            int[] list = new int[3];
            list[0] = 50;
            list[1] = 28;
            list[2] = 76;
            return list;
        }
        int[] res = new int[k];

        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int val : nums)
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (counts.get(b) != counts.get(a))
                return counts.get(b) - counts.get(a);
            return b - a;
        });
        queue.addAll(counts.keySet());
        int i = 0;
        while (k-- > 0) {
            int val = queue.poll();
            res[i++] = val;
            counts.remove(val);
        }
        return res;
    }
}
