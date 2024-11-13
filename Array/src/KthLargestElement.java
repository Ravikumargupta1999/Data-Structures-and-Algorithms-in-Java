import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement
{
    public static void main(String[] args) {
        PriorityQueue<Integer> Pq = new PriorityQueue<>();

        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<arr.length;i++)
            arr[i]=s.nextInt();

        for(int i=0;i<k;i++)
        {
            Pq.add(arr[i]);
        }
        System.out.print("Array :  ");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"  ");
        System.out.println();
        for(int i=k;i<arr.length;i++)
        {
            if(Pq.peek()<arr[i])
            {
                Pq.poll();
                Pq.add(arr[i]);
            }
        }

        System.out.print("Kth Largest element is :  ");
        System.out.print(Pq.remove());
    }
}
