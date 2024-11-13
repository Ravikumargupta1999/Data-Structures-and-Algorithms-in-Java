public class Majority_Element {
    // https://leetcode.com/problems/majority-element/submissions/
    public static int majorityElement(int[] nums) {
        int count = 1;
        int ans = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == ans)
            {
                count++;
            }
            else
            {
                count--;
                if(count == 0)
                {
                    count = 1;
                    ans = nums[i];
                }
            }
        }
        System.out.println(ans+"   "+count);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3};
        majorityElement(arr);

    }
}
