public class Video_38_Maximum_Sum_of_Two_Non_Overlapping_Subarray {
    // https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
//    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
//        return Math.max(maxSum(nums, firstLen, secondLen), maxSum(nums, secondLen, firstLen));
//    }

    public static int maxSum(int[] arr, int x, int y) {
        int n = arr.length;
        int[] leftX = new int[n];

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            if (i < x - 1) {
                leftSum += arr[i];
                leftX[i] = 0;
            } else {

                leftSum += arr[i];

                int left = i - 1 >= 0 ? leftX[i - 1] : 0;
                leftX[i] = Math.max(left, leftSum);

                leftSum -= arr[i - x + 1];

            }

        }


        int[] rightY = new int[n];
        int rightSum = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (i > n - y) {
                rightSum += arr[i];
                rightY[i] = 0;
            } else {
                rightSum += arr[i];
                int rightMax = i + 1 < n ? rightY[i + 1] : 0;
                rightY[i] = Math.max(rightMax, rightSum);
                rightSum -= arr[i + y - 1];
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(i + "   " + leftX[i] + "   " + rightY[i]);
            max = Math.max(max, leftX[i] + rightY[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        System.out.println(maxSum(arr, 1, 2));
    }
}
