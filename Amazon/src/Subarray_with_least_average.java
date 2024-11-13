public class Subarray_with_least_average {
    public static int least_average(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int index = -1;
        // System.out.println(nums.length-k);
        for (int i = 0; i < nums.length - k + 1; i++) {
            int temp = 0;
            for (int j = i; j < i + k; j++) {
                temp += nums[j];
            }
            if (temp < ans) {
                ans = temp;
                index = i;
            }
        }
        // System.out.print(ans+"   ");
        return index + 1;
    }

    public static void main(String[] args) {
        System.out.println(least_average(new int[]{7, 18, 17, 14, 17, 11, 12, 18, 7}, 8));
    }
}
