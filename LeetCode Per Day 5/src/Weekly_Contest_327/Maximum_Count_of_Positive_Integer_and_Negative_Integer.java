package Weekly_Contest_327;

public class Maximum_Count_of_Positive_Integer_and_Negative_Integer {
    public static void main(String[] args) {
        int[] arr ={0,0,0,0};
        System.out.println(maximumCount(arr));
    }
    public static int maximumCount(int[] nums) {
        int lastNegative = lastNegative(nums);
        int firstPositive = firstPositive(nums);
        System.out.println(lastNegative+"   "+firstPositive);
        return Math.max(0, Math.max(lastNegative + 1, nums.length - firstPositive));
    }

    public static int lastNegative(int[] nums) {
        int ans = -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (nums[mid] < 0) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int firstPositive(int[] nums) {
        int ans = nums.length;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (nums[mid] > 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
