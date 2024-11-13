package One;

import java.util.ArrayList;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1/
public class Nearly_Sorted {
    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        PriorityQueue<Integer> meanHeap = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            meanHeap.add(arr[i]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = k + 1; i < arr.length; i++) {
            arrayList.add(meanHeap.poll());
            meanHeap.add(arr[i]);
        }
        while (!meanHeap.isEmpty()) {
            arrayList.add(meanHeap.poll());
        }
        return arrayList;
    }
}
