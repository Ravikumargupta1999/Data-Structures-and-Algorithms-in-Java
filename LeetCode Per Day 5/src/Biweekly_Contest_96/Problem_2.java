package Biweekly_Contest_96;

public class Problem_2 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0)
            return fun(nums1, nums2, k);
        long pls = 0;
        long neg = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (Math.abs(nums1[i] - nums2[i]) % k != 0)
                return -1;
            if (nums1[i] - nums2[i] > 0)
                pls += (nums1[i] - nums2[i]);
            else
                neg += (Math.abs(nums1[i] - nums2[i]));
        }
        if (pls != neg)
            return -1;
        return pls / k;
    }

    public long fun(int[] nums1, int[] nums2, int k) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i])
                return -1;
        }
        return 0;
    }
}
