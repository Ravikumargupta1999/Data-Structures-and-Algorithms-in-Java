package Two;

// https://www.youtube.com/watch?v=SxtxCSfSGlo
public class Count_The_Subarrays_Having_Product_Less_Than_K {
    // https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        if (k <= 1)
            return 0;
        long prod = 1;
        long left = 0;
        long right = 0;
        int res = 0;
        while (right < n) {
            prod *= a[(int) right];

            while (prod >= k) {
                prod /= a[(int) left];
                left++;
            }

            res += (right - left + 1);
            right++;
        }
        return res;
    }

    // https://leetcode.com/problems/subarray-product-less-than-k/submissions/
    public int numSubarrayProductLessThanK(int[] a, int k) {
        if (k <= 1)
            return 0;
        int n = a.length;
        int prod = 1;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < n) {
            prod *= a[right];

            while (prod >= k) {
                prod /= a[left];
                left++;
            }

            res += (right - left + 1);
            right++;
        }
        return res;
    }
}
