public class Partition_Array_into_Disjoint_Interval {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightmin = new int[n+1];
        rightmin[n] = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            rightmin[i] = Math.min(rightmin[i+1],nums[i]);
        }
        // Maintain leftmax and figure out partition index
        int leftmax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            leftmax = Math.max(leftmax,nums[i]);
            if(leftmax <= rightmin[i+1]) {
                ans = i;
                break;
            }
        }
        return ans+1;
    }
}
