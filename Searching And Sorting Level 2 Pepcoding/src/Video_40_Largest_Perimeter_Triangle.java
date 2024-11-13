import java.util.Arrays;

public class Video_40_Largest_Perimeter_Triangle {
    // https://leetcode.com/problems/largest-perimeter-triangle/submissions/
    // https://practice.geeksforgeeks.org/problems/maximum-perimeter-of-triangle-from-array4322/1/
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i])
                return nums[i - 1] + nums[i - 2] + nums[i];
        }
        return 0;
    }
}
