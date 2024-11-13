import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
// https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/?category[]=Arrays&category[]=Arrays&page=29&query=category[]Arrayspage29category[]Arrays#

public class IPL_2021 {
    static ArrayList<Integer> max_of_sub_arrays(int arr[], int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i<n-k+1;i++)
        {
            int temp = k;
            int sum = 0;
            int j = i;
            while (temp-- >0)
            {
                pq.add(arr[j]);
                j++;
            }
            al.add(pq.peek());
            pq.remove(arr[i]);
        }
        System.out.println(al.size());
        return al;
    }

    public static void main(String[] args) {
        int N = 9, K = 3;
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(max_of_sub_arrays(arr,N,K));
    }
}
