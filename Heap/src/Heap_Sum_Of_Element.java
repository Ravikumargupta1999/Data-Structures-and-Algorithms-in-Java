import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_Sum_Of_Element {
    public static long sumBetweenTwoKth(long arr[], long n, long k1, long k2) {

        long l1 = kthSmallest(arr, k1);
        long l2 = kthSmallest(arr, k2);
        long sum = 0;
        for (long l = 0; l < n; l++)
            if (arr[(int) l] >= l1 && arr[(int) l] <= l2)
                sum += arr[(int) l];
        return sum - arr[(int) l1] - arr[(int) l2];

    }

    public static long kthSmallest(long[] arr, long k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (long i = 0; i < k; i++) {
            pq.add(arr[(int) i]);
        }

        for (long i = k; i < arr.length; i++) {
            if (pq.peek() > arr[(int) i]) {
                pq.poll();
                pq.add(arr[(int) i]);
            }
        }
        long count = pq.remove();
        return count;
    }

}
