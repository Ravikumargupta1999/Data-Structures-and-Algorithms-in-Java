import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/k-subarray-sum/0/?page=2&query=page2#

public class K_Subarray_Sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- >0)
        {
            int n = s.nextInt();
            int k = s.nextInt();
            int m = s.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = s.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i =0;i<n-k+1;i++)
            {
                int temp = k;
                int sum = 0;
                int j = i;
                while (temp-- >0)
                {
                    sum = sum + arr[j];
                    j++;
                }
                pq.add(sum);
            }
            while (m-- >0)
                System.out.print(pq.poll()+"  ");
            System.out.println("");
        }


    }
}
//2
//        5 2 3
//        10 11 10 11 12
//        5 5 1
//        1 2 3 4 5