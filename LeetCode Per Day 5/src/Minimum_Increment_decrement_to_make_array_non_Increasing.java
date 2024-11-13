import java.util.Collections;
import java.util.PriorityQueue;

public class Minimum_Increment_decrement_to_make_array_non_Increasing {
//    https://www.youtube.com/watch?v=U8JVBlYr_pY
    public static int minOperations(int a[], int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (int num : a) {
            if (minHeap.size() != 0 && minHeap.peek() < num) {
               int diff = num - minHeap.peek();
               minHeap.poll();
               minHeap.add(num);
               count += diff;
            }

            minHeap.add(num);
        }
        return count;
    }
}
