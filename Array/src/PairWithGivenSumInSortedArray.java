import java.util.HashSet;
import java.util.Scanner;

public class PairWithGivenSumInSortedArray {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i] = s.nextInt();
        int k = s.nextInt();
        int value = CountPair(arr,n,k);
        System.out.println(value);
    }
    public static int CountPair(int[] arr,int n,int k)
    {

        int count = 0;
        int low =0;
        int high = arr.length-1;
        //HashMap<Integer,Integer> hashMap = new HashMap<>();
        while(low<high)
        {

            if(arr[low]+arr[high] <  k)
                low++;
            else if(arr[low]+arr[high] > k)
                high--;
            else if(arr[low]+arr[high] == k){
                count++;
                high--;
                low++;
            }
        }

        if (count == 0)
            return -1;
        return count;

    }
}
