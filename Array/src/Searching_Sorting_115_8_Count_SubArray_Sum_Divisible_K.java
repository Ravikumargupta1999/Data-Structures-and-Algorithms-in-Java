import java.util.HashMap;

public class Searching_Sorting_115_8_Count_SubArray_Sum_Divisible_K {
    // https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/717547681/


    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int index = -1;
        int sum = 0;

        map.put(0, 1);

        int count = 0;

        while (index < nums.length - 1) {

            index++;

            sum = sum + nums[index];

            int remainder = sum % k;
            if (remainder < 0)
                remainder = remainder + k;

            if (map.containsKey(remainder))
                count = count + map.get(remainder);

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }


}
