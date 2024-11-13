import java.util.HashMap;
import java.util.Scanner;

public class Searching_Sorting_115_6_Longest_SubArray_With_Given_Sum {
    // https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#
    public static int lenOfLongestSubArray(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;


        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == k)
                maxlen = i + 1;
            if (map.containsKey(sum) == false)
                map.put(sum, i);
            if (map.containsKey(sum - k))
                if (maxlen < i - map.get(sum - k))
                    maxlen = i - map.get(sum - k);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.println("");
        int target = s.nextInt();
        System.out.println(lenOfLongestSubArray(arr, n, 5));
    }

}
