package HashMap_And_Heaps;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1
public class K_Largest_Elements_in_an_Array {
    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : arr)
            pq.add(val);
        for (int i = 0; i < k; i++)
            al.add(pq.poll());
        return al;
    }
}
