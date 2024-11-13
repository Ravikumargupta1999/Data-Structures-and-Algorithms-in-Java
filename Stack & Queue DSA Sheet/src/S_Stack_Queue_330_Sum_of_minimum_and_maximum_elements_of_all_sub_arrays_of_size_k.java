import java.util.*;

public class S_Stack_Queue_330_Sum_of_minimum_and_maximum_elements_of_all_sub_arrays_of_size_k {
    // TC : O(n*k)
    // SC : O(1)
    public static long sumOfMaxAndMin(ArrayList<Integer> num, int n, int k) {
        long result = 0;
        for (int l = 0; l < num.size() - k + 1; l++) {
            int max = num.get(l);
            int min = num.get(l);
            int count = 0;
            while (count < k) {
                max = Math.max(max, num.get(l + count));
                min = Math.min(min, num.get(l + count));
                count++;
            }
            result += max + min;

        }

        return result;
    }

    // TC : O(n*k)
    // SC : O(1)
    // Will not work for array containing duplicate elements
    public static long sumOfMaxAndMin1(ArrayList<Integer> arr, int n, int k) {
        long sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                maxHeap.add(arr.get(i));
                minHeap.add(arr.get(i));
            } else {
                maxHeap.add(arr.get(i));
                minHeap.add(arr.get(i));
                sum += maxHeap.peek();
                sum += minHeap.peek();
                maxHeap.remove(arr.get(j));
                minHeap.remove(arr.get(j));
                j++;
            }
        }
        return sum;
    }

     /*
    Time Complexity: O(N)
    Space Complexity: O(K),

    Where N is the number of elements in the array, K is the size of the subarray.
*/

    public static long sumOfMaxAndMin11(ArrayList<Integer> nums, int n, int k) {
        // Initialize a variable to store final result
        long totalSum = 0;

        Deque<Integer> minDQ = new LinkedList<>();
        Deque<Integer> maxDQ = new LinkedList<Integer>();

        for (int i = 0; i < k; i++) {

            // The current element
            int curr = nums.get(i);

            while (!minDQ.isEmpty() && nums.get(minDQ.getLast()) >= curr) {
                minDQ.removeLast();
            }

            while (!maxDQ.isEmpty() && nums.get(maxDQ.getLast()) <= curr) {
                maxDQ.removeLast();
            }

            minDQ.add(i);
            maxDQ.add(i);
        }

        // Add minimum and maximum values of this window to the final result.
        totalSum += nums.get(minDQ.getFirst()) + nums.get(maxDQ.getFirst());

        for (int i = k; i < n; i++) {

            // The current element
            int curr = nums.get(i);

            // Remove all indices from both the Dequeues that are not in the current window.
            while (!minDQ.isEmpty() && minDQ.getFirst() <= i - k) {
                minDQ.removeFirst();
            }

            while (!maxDQ.isEmpty() && maxDQ.getFirst() <= i - k) {
                maxDQ.removeFirst();
            }

            // Remove all previous greater elements from the rear end.
            while (!minDQ.isEmpty() && nums.get(minDQ.getLast()) >= curr) {
                minDQ.removeLast();
            }

            // Remove all previous smaller elements from the rear end.
            while (!maxDQ.isEmpty() && nums.get(maxDQ.getLast()) <= curr) {
                maxDQ.removeLast();
            }

            // Insert the current index to both the Dequeues.
            minDQ.add(i);
            maxDQ.add(i);

            // Add minimum and maximum values of this window to the final result.
            totalSum += nums.get(minDQ.getFirst()) + nums.get(maxDQ.getFirst());

        }

        return totalSum;
    }
}