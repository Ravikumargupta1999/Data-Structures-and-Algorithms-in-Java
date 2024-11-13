public class Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
    // https://leetcode.com/submissions/detail/729979288/
    int count;
    public int numSubseq(int[] nums, int target) {
        count = 0;
        solve(0, nums, target, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return count;
    }
    public void solve(int index,int[] nums,int target,int min,int max){
        if(index == nums.length){
            if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE)
                return;
            if(min + max <= target)
                count++;
            return;
        }
        solve(index+1,nums,target,Math.min(nums[index],min),Math.max(max,nums[index]));
        solve(index+1,nums,target,min,max);

    }
}
