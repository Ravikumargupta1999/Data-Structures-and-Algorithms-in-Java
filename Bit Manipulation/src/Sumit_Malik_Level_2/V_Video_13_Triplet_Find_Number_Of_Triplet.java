package Sumit_Malik_Level_2;

public class V_Video_13_Triplet_Find_Number_Of_Triplet {
    // https://www.youtube.com/watch?v=sdJBPdoD3OY&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=13
    // https://www.geeksforgeeks.org/number-of-triplets-in-array-having-subarray-xor-equal/
//    https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    ans += (j - i);
                }
            }
        }
        return ans;
    }



}
