package Biweekly_Contest_71;

import java.util.ArrayList;

public class Partition_Array_According_to_Given_Pivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int count = 0;
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> higher = new ArrayList<>();

        for (int num : nums){
            if(num < pivot)
                less.add(pivot);
            else if(num == pivot)
                count++;
            else
                higher.add(num);
        }
        int[] res = new int[nums.length];
        int i = 0;
        for (int j=0;j<less.size();j++)
            res[i++] = less.get(i);
        while (count-- > 0)
            res[i++] = pivot;
        for (int j=0;j<higher.size();j++)
            res[i++] = higher.get(j);
        return res;
    }
}
