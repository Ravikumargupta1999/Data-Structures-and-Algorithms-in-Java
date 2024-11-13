package Day_4_Arrays_;

import java.util.Arrays;
import java.util.HashSet;

public class Longest_Consecutive_System {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);


        for (int i = 0; i < n; ++i) {
            if (!S.contains(arr[i] - 1)) {
                int j = arr[i];
                while (S.contains(j)) {
                    S.remove(j);
                    j++;
                }
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

    public int longestConsecutive1(int[] arr) {
        Arrays.sort(arr);

        int res = 0;
        int i = 0;

        while (i < arr.length) {
            int count = 1;
            int prev = arr[i];
            i++;
            while (i < arr.length && prev + 1 == arr[i]) {
                count++;
                prev = arr[i];
                i++;
            }
            res = Math.max(res, count);
        }
        return res;

    }
}
