public class How_Many_Numbers_Are_Smaller {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            int temp = nums[i];
            for (int j = 0; j < ans.length; j++) {
                if (nums[j] < temp)
                    ans[i] += 1;
            }
        }
        return ans;

    }
}
