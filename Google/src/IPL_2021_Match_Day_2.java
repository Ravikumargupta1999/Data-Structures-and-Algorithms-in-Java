import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/0/?fbclid=IwAR1edprt9d8vk_Y2SrTA5u0lq-dsb6Bj5OeBvqW5YjgkiHPPll90ssmD0NM

public class IPL_2021_Match_Day_2 {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k - 1; i++) {
            pq.add(arr[i]);
        }
        for (int i = k - 1; i < n; i++) {
            pq.add(arr[i]);
            al.add(pq.peek());
            pq.remove(arr[i - k + 1]);
        }
        return al;
    }

    public static void main(String[] args) {
        int[] arr = {5};
        System.out.println(max_of_subarrays(arr, arr.length, 1));
    }
}
