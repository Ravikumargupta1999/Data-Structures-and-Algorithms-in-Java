package HashMap_And_Heaps;

import java.util.PriorityQueue;
import java.util.Scanner;
// https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0#
public class Sort_a_nearly_sorted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t--> 0)
        {
            int n = scn.nextInt();
            int[] arr = new int[n];
            int k = scn.nextInt();
            for (int i=0;i<arr.length;i++)
            {
                arr[i] = scn.nextInt();
            }

//            int k = scn.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<n;i++)
            {
                if(i < k)
                {
                    pq.add(arr[i]);
                }
                else
                {
                    System.out.print(pq.poll()+" ");
                    pq.add(arr[i]);
                }
            }
            while (!pq.isEmpty())
                System.out.print(pq.poll()+" ");
            System.out.print("\n");
        }
    }
}
