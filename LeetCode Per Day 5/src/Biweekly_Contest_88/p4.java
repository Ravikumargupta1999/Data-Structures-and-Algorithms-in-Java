package Biweekly_Contest_88;

public class p4 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3};
        int[] arr2 = {10, 2, 5, 0};
        System.out.println(new p4().xorAllNums(arr, arr2));
        System.out.println(new p4().bruteForce(arr, arr2));
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n % 2 != 0 && m % 2 != 0)
            return xor(nums1) ^ xor(nums2);
        else if (n % 2 != 0)
            return xor(nums2);
        else
            return xor(nums1);
    }

    public int xor(int[] arr) {
        int xor = 0;
        for (int x : arr)
            xor = xor ^ x;
        return xor;
    }

    int bruteForce(int[] nums1, int[] nums2) {
        int xor = 0;
        for (int num : nums1) {
            for (int num2 : nums2) {
                xor = xor ^ num2;
            }
        }
        return xor;
    }
}
