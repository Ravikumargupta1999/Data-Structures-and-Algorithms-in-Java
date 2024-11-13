import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/submissions/
public class Move_Zeroes {
    public static void moveZeroes(int[] nums) {
        int i =0;
        int j = 1;
        while (i < nums.length && j < nums.length)
        {
            if(nums[i] == 0 && nums[j] != 0)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if(i < j)
            {
                if(nums[i] != 0)
                {
                    i++;
                }
                if(nums[j] == 0)
                {
                    j++;
                }
            }
            else
            {
                if(nums[i] != 0)
                {
                    i++;
                }
                if(nums[j] != 0 || nums[j] == 0)
                {
                    j++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(arr);
    }
}
