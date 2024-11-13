import java.util.Arrays;

public class Array_Partition {
    // https://leetcode.com/problems/array-partition/submissions/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i=0;i<nums.length;i++)
            res += nums[i];
        return res;

    }
}
