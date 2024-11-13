public class Searching_Sorting_112_House_Robber_II {
//    public static void main(String[] args) {
//        int[] arr= {1,2,3,1};
//        System.out.println(rob(arr));
//    }
    // https://leetcode.com/problems/house-robber-ii/submissions/892208219/
    // https://www.youtube.com/watch?v=3WaxQMELSkw
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];
        int l = 0;
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i != 0)
                arr1[l++] = nums[i];
            if(i != nums.length-1)
                arr2[m++] = nums[i];
        }
        return Math.max(rob1(arr1),rob1(arr2));
    }

    public int rob1(int[] arr) {
        int inc = arr[0];
        int exc = 0;
        for (int i = 1; i < arr.length ; i++) {

            int ninc = exc + arr[i];
            int nexc = Math.max(inc, exc);
            inc = ninc;
            exc = nexc;

        }
        return Math.max(inc, exc);
    }
}
