import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode_2161_Partition_Array_According_to_Given_Pivot {
    // https://leetcode.com/problems/partition-array-according-to-given-pivot/submissions/
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int count = 0;
        for (int val : nums) {
            if (val < pivot)
                list1.add(val);
            else if (val == pivot)
                count++;
        }

        for (int val : nums) {
            if (val > pivot)
                list2.add(val);
        }
        int k = 0;
        for (int i = 0; i < list1.size(); i++) {
            nums[k++] = list1.get(i);
        }
        while (count-- > 0){
            nums[k++] = pivot;
        }
        for (int i = 0; i < list2.size(); i++) {
            nums[k++] = list2.get(i);
        }
        return nums;
    }
}
