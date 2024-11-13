import java.util.PriorityQueue;

public class Heap_349_N_Ropes_With_Minimum_Cost {
    long minCost(long[] arr, int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[(int) i]);
        }
        System.out.println(pq.peek());
        while (pq.size() > 1) {
            long l = pq.poll();
            long m = pq.poll();
            pq.add(l + m);
        }
        return pq.poll();

    }
}
