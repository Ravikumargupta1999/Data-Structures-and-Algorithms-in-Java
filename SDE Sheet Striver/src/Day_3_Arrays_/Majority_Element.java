package Day_3_Arrays_;

public class Majority_Element {
    public int majorityElement(int[] nums) {
        int count = 1;
        int ele = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ele) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    ele = nums[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == ele)
                count++;
        }
        if (count > nums.length / 2)
            return ele;
        return -1;


    }
}
