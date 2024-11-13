package Weekly_Contest_328;

import java.util.HashMap;
import java.util.HashSet;

public class Problem_3 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 3, 2, 2, 4};
        System.out.println(countGood(arr, 2));
    }

    public static long countGood(int[] arr, int k) {
        long pair = 0;
        long count = 0;
        int left = 0;
        int right = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            // Calculating the frequency of each
            // element in the current window
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            // Shrinking the window from left if the
            // count of distinct elements exceeds K
            if (map.get(arr[right]) > 1) {
                pair += (map.get(arr[right]) - 1);
            }

            if (pair >= k)
                count++;
            System.out.println(count + "   " + pair);
            System.out.println(left + "   " + right + "   " + count + "   " + pair + "  " + map);
            while (pair >= k) {
                System.out.println("left :   " + arr[left] + "   " + count + "    " + pair);
                if (map.get(arr[left]) > 1) {
                    pair -= (map.get(arr[left]) - 1);
                }
                System.out.println("Hii  : " + count + "   " + pair);
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0)
                    map.remove(arr[left]);
                System.out.println(pair + "  " + map);
                if (pair >= k)
                    count++;
                left++;
                System.out.println(count);
                System.out.println(pair);
            }
            System.out.println("right :   " + arr[right] + "   " + count + "    " + pair);
            right++;
            System.out.println("\n\n");

        }
        return count;
    }
    // https://leetcode.com/problems/valid-perfect-square/submissions/879380918/
    public boolean isPerfectSquare(int x) {
        if (x >= 0) {
            int sr = (int) Math.sqrt(x);
            return ((sr * sr) == x);
        }

        return false;
    }
}
