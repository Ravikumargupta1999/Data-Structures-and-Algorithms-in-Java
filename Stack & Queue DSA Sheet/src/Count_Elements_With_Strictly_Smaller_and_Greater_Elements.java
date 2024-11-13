import java.util.Arrays;

public class Count_Elements_With_Strictly_Smaller_and_Greater_Elements {

    // https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/submissions/
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        int count =0;
        for(int i=1;i<nums.length-1;i++){
            if(min < nums[i] && max > nums[i])
                count++;
        }
        return count;
    }
}
