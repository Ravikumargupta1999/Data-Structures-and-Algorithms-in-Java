package Sumit_Malik_Level_2;

public class V_Video_10_Duplicate_And_Missing_From_1_to_N {
    // https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1/
    // https://www.youtube.com/watch?v=MvklwzVz654&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=10
    int[] findTwoElement(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++)
            xor ^= arr[i];

        for (int i = 1; i <= arr.length; i++)
            xor ^= i;

        int rightMostSetBits = xor & -xor;

        int x = 0;
        int y = 0;
        for (int val : arr)
            if ((val & rightMostSetBits) == 0)
                x = x ^ val;
            else
                y = y ^ val;

        for (int i = 1; i <= arr.length; i++)
            if ((i & rightMostSetBits) == 0)
                x = x ^ i;
            else
                y = y ^ i;

        int[] arr1 = new int[2];
        for (int val : arr)
            if (val == x) {
                arr1[0] = x;
                arr1[1] = y;
            } else if (val == y) {
                arr1[0] = y;
                arr1[1] = x;
            }
        return arr1;
    }
}
