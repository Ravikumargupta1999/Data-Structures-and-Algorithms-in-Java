package Weekly_Contest_323;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Longest_Square_Streak_In_An_Array {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 16, 8, 2};
        System.out.println(longestSquareStreak(arr));
    }

    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int ans = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int count = 1;

            while (map.containsKey(num) && map.containsKey(num * num)) {
                // System.out.println(num);
                if (map.get(num) == 1)
                    map.remove(num);
                else
                    map.put(num, map.get(num) - 1);
                count++;
                num = num * num;
            }
            if (count > 1) {
                // System.out.println(num);
                ans = Math.max(ans, count);
                if (map.get(num) == 1)
                    map.remove(num);
                else
                    map.put(num, map.get(num) - 1);
            }
            // System.out.println("\n");
        }
        return ans;
    }
}
