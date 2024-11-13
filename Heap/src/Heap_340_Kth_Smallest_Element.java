import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_340_Kth_Smallest_Element {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//        maxHeap.add(1);
//        maxHeap.add(2);
//        maxHeap.add(3);
//        maxHeap.add(4);
        System.out.println(maxHeap.peek());


        for (int i = 0; i <= r; i++) {
            if (i < k - 1) {
                maxHeap.add(arr[i]);
            } else {
               if(arr[i] < maxHeap.peek())
               {
                   maxHeap.poll();
                   maxHeap.add(arr[i]);
               }
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 20, 15};
        System.out.println(kthSmallest(arr, 0, arr.length - 1, 4));
    }
}
