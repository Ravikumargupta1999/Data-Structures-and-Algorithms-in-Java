public class Squares_of_a_Sorted_Array {
    // https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
    // https://www.youtube.com/watch?v=u3A64HQq_Dw&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=4
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[j + 1];
        int k = nums.length - 1;
        while (i <= j) {
            if ((nums[i] * nums[i]) > (nums[j] * nums[j])) {
                res[k--] = (nums[i] * nums[i]);
                i++;
            } else {
                res[k--] = (nums[j] * nums[j]);
                j--;
            }
        }
        return res;
    }
}
