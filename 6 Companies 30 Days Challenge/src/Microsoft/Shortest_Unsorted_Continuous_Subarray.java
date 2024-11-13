package Microsoft;

 class Shortest_Unsorted_Continuous_SubArray {
    // https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
     // https://www.youtube.com/watch?v=GvAtQOMr8CQ
    public int findUnsortedSubArray(int[] nums) {
        int end = -1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max > nums[i])
                end = i;
            else
                max = nums[i];
        }
        int st = 0;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min)
                st = i;
            else
                min = nums[i];
        }
        return end - st + 1;
    }
}
