import java.util.HashMap;

public class Video_31_Contiguous_Array {
//  https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1#:~:text=Input%3A%20N%20%3D%204%20A%5B%5D,0's%20and%201's%20is%204.
//  https://leetcode.com/problems/contiguous-array/submissions/
    public int findMaxLength(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;

    }
}
