package InterviewQuestion;

import java.util.HashMap;
import java.util.PriorityQueue;
// https://leetcode.com/problems/reduce-array-size-to-the-half/submissions/
public class Leetcode_Reduce_Array_Size_To_The_Half {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int ele : arr){
            counts.put(ele,counts.getOrDefault(ele,0)+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return counts.get(b) - counts.get(a);
        });


//        System.out.println(counts);
        queue.addAll(counts.keySet());

        int total = arr.length;
        int count = 0;
        while (total >= arr.length / 2) {
            int val = queue.peek();
            total -= counts.get(val);
            queue.remove(val);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7};
        System.out.println(new Leetcode_Reduce_Array_Size_To_The_Half().minSetSize(arr));
    }
}
