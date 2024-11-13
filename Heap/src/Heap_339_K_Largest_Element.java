import java.util.Arrays;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1
public class Heap_339_K_Largest_Element {
    int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int val : arr) {
            if (minheap.size() < k)
                minheap.add(val);
            else {
                minheap.add(val);
                minheap.poll();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (!minheap.isEmpty()) {
            ans[i++] = minheap.poll();
        }
        return reverse(ans);
    }

    public int[] reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 787, 1, 23};
        System.out.println(Arrays.toString(new Heap_339_K_Largest_Element().kLargest(arr, arr.length, 5)));
    }
}
