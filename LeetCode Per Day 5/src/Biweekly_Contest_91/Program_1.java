package Biweekly_Contest_91;

import java.util.Arrays;
import java.util.HashSet;

public class Program_1 {
    public static void main(String[] args) {
        int[] nums = {1,100};
        System.out.println(distinctAverages(nums));
    }
    public static int distinctAverages(int[] nums) {
        HashSet<Double> set = new HashSet<>();
        int i=0;
        int j = nums.length-1;
        Arrays.sort(nums);
        while (i < j){
            double d1 = nums[i];
            double d2 = nums[j];
            i++;
            j--;

            set.add(((d1+d2)/2));
            System.out.println(set);
        }
        return set.size();
    }
}
