public class Array_28_Maximum_Product_SubArray {
    // https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1
    // Brute Force
    // TC : O(n^2)
    // SC : O(1)
    // Accepted
    public static int maxSubArraySum(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, temp);
                temp *= arr[j];
            }
            max = Math.max(max, temp);
        }
        return max;
    }


    // https://www.youtube.com/watch?v=jzQ-f2uU0UU&t=68s
    long maxProduct(int[] arr, int n) {
        long res = Long.MIN_VALUE;
        long currProd = 1;
        for (int i = 0; i < arr.length; i++) {
            currProd *= arr[i];
            res = Math.max(res, currProd);
            if (currProd == 0)
                currProd = 1;
        }
        currProd = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            currProd *= arr[i];
            res = Math.max(res, currProd);
            if (currProd == 0)
                currProd = 1;
        }
        return res;
    }

    long maxProduct1(int[] arr, int n) {
        long min = arr[0];
        long max = arr[0];
        long product = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                long temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i], max * arr[i]);
            min = Math.min(arr[i], min * arr[i]);
            product = Math.max(product, max);
        }
        // Long l = new Long(product);
        return product;
    }
}
