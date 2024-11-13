import java.util.Collections;
import java.util.PriorityQueue;
//Done
public class Array8_Kth_Smallest_Element {
    // https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
    public static int findKhSmallest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.add(nums[i]);
            } else {
                if (nums[i] < minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}
