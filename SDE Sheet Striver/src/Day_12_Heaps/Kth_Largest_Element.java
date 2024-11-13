package Day_12_Heaps;

import java.util.PriorityQueue;

public class Kth_Largest_Element {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(i < k)
                minHeap.add(nums[i]);
            else {
                if(nums[i] > minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}
