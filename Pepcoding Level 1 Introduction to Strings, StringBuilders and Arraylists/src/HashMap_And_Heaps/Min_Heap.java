package HashMap_And_Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Min_Heap {
    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 15};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr)
            minHeap.add(val);
        while (!minHeap.isEmpty())
            System.out.print(minHeap.poll() + "  ");
        System.out.println("\n");
    }

}
