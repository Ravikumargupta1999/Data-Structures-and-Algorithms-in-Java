package Microsoft;

public class Rotate_Function {
    // https://leetcode.com/problems/rotate-function/submissions/868533728/
    // https://www.youtube.com/watch?v=yroWfS5P2E4&t=1230s
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int s0 = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            s0 += (i * nums[i]);
        }

        int max = s0;
        int s1 = s0;

        for (int i = 0; i < n - 1; i++) {

            int sip1 = s1 + sum - n * nums[n - i - 1];

            if(sip1 > max)
                max = sip1;
            s1 = sip1;
        }
        return max;
    }
}
