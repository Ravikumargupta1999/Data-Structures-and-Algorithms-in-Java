package HashMap_And_Heaps;

import java.util.HashMap;
import java.util.Scanner;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    // https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1#
    // https://www.youtube.com/watch?v=YWXbu5uyGXs&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=9
    // https://leetcode.com/problems/longest-consecutive-sequence/submissions/
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val : nums)
            map.put(val, true);
        for (int val : nums)
            if (map.containsKey(val - 1))
                map.put(val, false);
        int len = 0;
        for (int val : nums) {
            if (map.get(val)) {
                int temp = 0;
                while (true) {
                    if (map.containsKey(val))
                        temp++;
                    else
                        break;
                    val++;
                }
                len = Math.max(len, temp);
            }
        }
        return len;

    }
}
