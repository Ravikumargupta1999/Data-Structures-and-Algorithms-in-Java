import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElement2 {
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
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<arr.length;i++)
            pq.add(arr[i]);
        int[] arr1 = new int[k];
        int temp = 0;
        while (temp < k) {
            arr1[temp] = pq.poll();
            temp++;
        }

        return arr1;
    }
}
