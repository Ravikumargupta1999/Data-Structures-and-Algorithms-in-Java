import java.util.HashMap;
import java.util.Scanner;

public class PairWithGivenSum2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i] = s.nextInt();
        int k = s.nextInt();
        int value = PairSum(arr,n,k);
        System.out.println(value);
    }
    public static int PairSum(int[] arr,int n,int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);
            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null) {
                twice_count += hm.get(sum - arr[i]);
                System.out.println(i+ "  and "+twice_count);
            }

                if (sum - arr[i] == arr[i]) {
                    twice_count--;
                    System.out.println(i+ "  and "+twice_count);
                }

        }
        return twice_count / 2;
    }
}
