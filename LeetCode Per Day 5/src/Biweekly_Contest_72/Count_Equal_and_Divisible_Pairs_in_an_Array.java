package Biweekly_Contest_72;

public class Count_Equal_and_Divisible_Pairs_in_an_Array {
    public int countPairs(int[] nums, int k) {
        int count= 0;
        for (int i=0;i<nums.length;i++)
        {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] == nums[i] && (i * j) % 2 == 0)
                    count++;
            }
        }
        return count;
    }
}
