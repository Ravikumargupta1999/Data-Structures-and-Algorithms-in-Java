import java.util.Arrays;
import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream2220/1/?company[]=OYO%20Rooms&company[]=OYO%20Rooms&page=3&query=company[]OYO%20Roomspage3company[]OYO%20Rooms#

public class Practice_17_Kth_largest_element_in_a_stream {
    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[n];
        for (int i = 0; i < n ; i++) {
            if (pq.size() < k)
                pq.add(arr[i]);
            else {
                if (arr[i] > pq.peek()) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
            if (pq.size() < k)
                ans[i] = -1;
            else
                ans[i] = pq.peek();
        }
        System.out.println(Arrays.toString(ans));
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 11, 70, 50, 40, 100, 5};
        kthLargest(3,arr,arr.length);
    }
}
