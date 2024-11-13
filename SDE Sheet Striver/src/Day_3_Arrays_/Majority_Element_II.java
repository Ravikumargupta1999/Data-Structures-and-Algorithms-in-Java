package Day_3_Arrays_;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II {
    // https://leetcode.com/problems/majority-element-ii/submissions/
    public List<Integer> majorityElement(int[] nums) {
        int val1 = nums[0];
        int count1 = 1;
        int val2 = nums[0];
        int count2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val1)
                count1++;
            else if (nums[i] == val2)
                count2++;
            else {
                if (count1 == 0) {
                    val1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    val2 = nums[i];
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        List<Integer> al = new ArrayList<>();
        if (count1 != 0)
            if (isValid(nums, val1))
                al.add(val1);
        if (count2 != 0)
            if (isValid(nums, val2))
                al.add(val2);
        return al;
    }

    public boolean isValid(int[] arr, int val) {
        int count = 0;
        for (int x : arr)
            if (x == val)
                count++;
        return (count > (arr.length / 3)) ? true : false;

    }
}
