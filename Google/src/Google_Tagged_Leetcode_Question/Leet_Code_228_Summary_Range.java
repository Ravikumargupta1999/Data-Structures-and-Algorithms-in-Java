package Google_Tagged_Leetcode_Question;

import java.util.ArrayList;
import java.util.List;

public class Leet_Code_228_Summary_Range {
    public static void main(String[] args) {
        int[] nums = {0,2,4,6,8,10};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        if(nums.length == 0)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];

        int i = 1;

        while (true) {

            while (i < nums.length && nums[i] == end + 1) {
                end = nums[i];
                i++;
            }
            if (start != end) {
                res.add(start + "->" + end);

            } else {
                res.add(start + "");
            }
            if (i < nums.length) {
                start = end = nums[i];
                i++;
                if(i == nums.length){
                    if (start != end) {
                        res.add(start + "->" + end);

                    } else {
                        res.add(start + "");
                    }
                }
            }
            if(i >= nums.length)
                break;

        }
        return res;
    }
}
