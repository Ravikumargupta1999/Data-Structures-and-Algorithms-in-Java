package HashMap_And_Heaps;

import java.text.Collator;
import java.util.Collections;
import java.util.PriorityQueue;

public class Max_Heap {
    public static void main(String[] args) {
        int[] arr = {12,3,4,15};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for( int val : arr)
            maxHeap.add(val);
        while (!maxHeap.isEmpty())
            System.out.print(maxHeap.poll()+"  ");
        System.out.println("\n");

    }
}
