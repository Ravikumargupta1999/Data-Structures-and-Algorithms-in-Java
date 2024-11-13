import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// codingninjas.com/codestudio/problems/k-th-largest-sum-contiguous-subarray_920398?leftPanelTab=1
public class Heap_343_Kth_largest_sum_continuous_subarrays {
    // https://practice.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1/
    public static int kthLargest(int n, int k, int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            if (queue.size() < k) {
                queue.add(sum);

            } else if (queue.size() == k && queue.peek() < sum) {
                queue.poll();
                queue.add(sum);
            }
            for (int j = i + 1; j < n; j++) {
                sum += arr[j];

                if (queue.size() < k) {
                    queue.add(sum);

                } else if (queue.size() == k && queue.peek() < sum) {
                    queue.poll();
                    queue.add(sum);
                }

            }
        }
        return queue.peek();
    }

}
