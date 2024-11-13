//https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
//Done
public class Array12_Cyclic_Rotation {
    //    https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
    public static void rotate(int[] arr, int n) {
        if (n == 1)
            return;
        int prev = arr[0];

        for (int i = 1; i < n; i++) {
            int next = arr[i];
            arr[i] = prev;
            prev = next;
        }
        arr[0] = prev;
    }

//    https://leetcode.com/problems/rotate-array/

    public void rotateArrayByK(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    public void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
