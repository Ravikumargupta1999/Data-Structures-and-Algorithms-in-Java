// Done
class Array13_LargestSumContiguousSubArray {

    public int maxSubArray(int[] nums) {
        int csum = nums[0];
        int osum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (csum >= 0) {
                csum += nums[i];
            } else {
                csum = nums[i];
            }
            osum = Math.max(osum, csum);
        }
        return osum;
    }

    // https://practice.geeksforgeeks.org/problems/maximum-no-of-1s-row3027/1/?page=2&curated[]=1&sortBy=submissions#
    // Method 1
    // Traverse Column wise
    public static int maxOnes(int arr[][], int N, int M) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 1)
                    return j;
            }
        }
        return -1;
    }

    // Method 2
    // Binary Search
    public static int maxOnes_(int[][] matrix, int N, int M) {
        int max = 0;
        int row = -1;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = M - 1;

            while (left <= right) {
                int mid = (left + right);
                if (matrix[i][mid] == 1)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            if ((M - left) > max) {
                max = M - left;
                row = i;
            }
        }
        return row;
    }
}

//    N = 3, M = 4
//    Mat[] = {{0 1 1 1},
//        {0 0 1 1},
//        {0 0 1 1}}
