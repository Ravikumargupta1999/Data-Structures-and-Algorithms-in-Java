import java.util.ArrayList;
import java.util.List;

public class Majority_Element_2 {
    // https://leetcode.com/problems/majority-element-ii/submissions/
    //https://www.youtube.com/watch?v=1QybAZMCYhA&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=7
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

    public static void main(String[] args) {
        Majority_Element_2 a = new Majority_Element_2();
        System.out.println(a.majorityElement(new int[]{3,2}));
    }
}
