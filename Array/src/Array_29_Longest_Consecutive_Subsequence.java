import java.util.HashMap;
import java.util.HashSet;

public class Array_29_Longest_Consecutive_Subsequence {

    // https://www.youtube.com/watch?v=YWXbu5uyGXs&t=383s
    // https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1#
    // https://leetcode.com/problems/longest-consecutive-sequence/submissions/
    public static int findLongestConsecutiveSubsequence1(int[] arr, int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val : arr)
            map.put(val, true);
        for (int val : arr)
            if (map.containsKey(val - 1))
                map.put(val, false);

        int maximumLength = 0;
        for (int val : arr) {
            if (map.get(val)) {
                int t1 = 1;
                int tsp = val;
                while (map.containsKey(tsp + t1))
                    t1++;
                if (t1 > maximumLength) {
                    maximumLength = t1;
                }
            }
        }
        return maximumLength;
    }

    static int findLongestConsecutiveSubsequence2(int arr[], int n)
    {
        // int n = arr.length;
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);
        for (int i = 0; i < n; ++i) {
            if (!S.contains(arr[i] - 1)) {
                int j = arr[i];
                while (S.contains(j)) {
                    // now j ko hashset se nikal do ab uska koi kaam nahi hai warna wo faltu complexity ko increase karega
                    S.remove(j);
                    j++;
                }
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }
}