import java.util.Arrays;

public class Product_of_Array_Except_Itself {
    // https://leetcode.com/problems/product-of-array-except-self/submissions/
    // https://www.youtube.com/watch?v=UBkpyXgx0g0&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=9
    public static int[] productExceptSelf(int[] nums) {
        int[] leftarr = new int[nums.length];
        int[] rightarr = new int[nums.length];
        leftarr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftarr[i] = leftarr[i - 1] * nums[i];
        }
        rightarr[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightarr[i] = rightarr[i + 1] * nums[i];
        }
        System.out.println(Arrays.toString(leftarr));
        System.out.println(Arrays.toString(rightarr));
        int[] ans = new int[nums.length];
        ans[0] = rightarr[1];
        ans[nums.length - 1] = leftarr[nums.length - 2];
        if (nums.length == 2)
            return ans;
        for (int i = 1; i < ans.length - 2; i++) {
            ans[i] = leftarr[i - 1] * rightarr[i + 1];
        }
        return ans;
    }
     // Correct and verified from leetcode
    public static int[] productExceptSel1(int[] nums) {
        int[] rightarr = new int[nums.length];

        rightarr[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightarr[i] = rightarr[i + 1] * nums[i];
        }
        int leftproduct = nums[0];
        int[] ans = new int[nums.length];
        if(nums.length == 2)
        {
            ans[0] = nums[1];
            ans[1] = nums[0];
            return ans;
        }
        ans[0] = rightarr[1];
        if (nums.length == 2)
            return ans;
        for (int i = 1; i < ans.length -1 ; i++) {
            ans[i] = leftproduct * rightarr[i + 1];
            leftproduct *= nums[i];
        }
        ans[nums.length - 1] = leftproduct;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSel1(arr)));
    }
}
