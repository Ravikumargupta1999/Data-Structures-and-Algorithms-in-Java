public class Find_Pivot_Index {
    // https://leetcode.com/problems/find-pivot-index/submissions/
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftsum = 0;
        for(int i=0;i<nums.length;i++)
        {
//            System.out.println(sum+"  "+leftsum);
            if(sum-nums[i] == leftsum)
                return i;
            sum -= nums[i];
            leftsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
