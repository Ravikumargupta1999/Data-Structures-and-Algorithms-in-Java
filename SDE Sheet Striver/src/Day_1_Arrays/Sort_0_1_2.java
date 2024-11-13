package Day_1_Arrays;

public class Sort_0_1_2 {
    // https://leetcode.com/problems/sort-colors/submissions/
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int val : nums){
            if(val == 0)
                count0++;
            else if( val == 1)
                count1++;
            else
                count2++;
        }
        int i=0;

        while (count0-- > 0){
            nums[i++] = 0;
        }
        while (count1-- > 0){
            nums[i++] = 1;
        }
        while (count2-- > 0){
            nums[i++] = 2;
        }

    }
}
