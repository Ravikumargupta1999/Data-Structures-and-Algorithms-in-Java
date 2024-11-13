public class Video_31_K_Concatenation_Maximum_Sum {
    // https://leetcode.com/problems/k-concatenation-maximum-sum/
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        for (int val : arr)
            sum += val;
        if (k == 1)
            return kadanes(arr);
        else if (sum < 0)
            return kadanesofTwo(arr);
        else
            return kadanesofTwo(arr) + (k - 2) * sum;
    }

    public int kadanesofTwo(int[] arr) {
        int[] narr = new int[2 * arr.length];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            narr[i + arr.length] = arr[i];
        }
        return kadanes(narr);
    }

    public int kadanes(int[] nums) {
        int csum = nums[0];
        int osum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (csum >= 0)
                csum += nums[i];
            else
                csum = nums[i];
            osum = Math.max(osum, csum);
        }
        return osum;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2};
        System.out.println(arr.length);
        System.out.println(new Video_31_K_Concatenation_Maximum_Sum().kadanes(arr));
    }
}
