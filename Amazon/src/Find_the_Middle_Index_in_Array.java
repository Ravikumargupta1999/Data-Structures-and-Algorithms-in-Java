public class Find_the_Middle_Index_in_Array {
// https://leetcode.com/problems/find-the-middle-index-in-array/submissions/
    public static int findMiddleIndex(int[] nums) {
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
    public static void main(String[] args){
        System.out.println(findMiddleIndex(new int[]{2,3,-1,8,4}));
    }
}
