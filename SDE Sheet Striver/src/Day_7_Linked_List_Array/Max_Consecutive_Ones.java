package Day_7_Linked_List_Array;

public class Max_Consecutive_Ones {
    // https://leetcode.com/problems/max-consecutive-ones/submissions/
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int num : nums){
            if(num == 0)
                count = 0;
            else
                count++;
            max = Math.max(count,max);
        }
        return max;
    }
}
