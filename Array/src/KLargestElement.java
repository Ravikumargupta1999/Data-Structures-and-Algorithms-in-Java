import javax.sql.rowset.spi.SyncProvider;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = s.nextInt();
        int[] arr1 = KLargest(arr,k);
        for(int i=0;i<arr1.length;i++)
            System.out.print(arr1[i]+" ");
        System.out.println("");

    }
    public static int[] KLargest(int[] arr,int k)
    {
        PriorityQueue<Integer> Pq = new PriorityQueue<>();
        for(int i=0;i<10;i++)
            Pq.add(i*i);
        while (!Pq.isEmpty())
            System.out.print(Pq.poll()+"   ");
        System.out.println("");

        int[] arr1=new int[k];
        for(int i=0;i<k;i++)
        {
            Pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++)
        {
            if(arr[i]>Pq.peek())
            {
                Pq.poll();
                Pq.add(arr[i]);
            }
        }
        for(int i=k-1;i>=0;i--)
        {
            arr1[i]=Pq.poll();
        }

        return arr1;
    }
}
