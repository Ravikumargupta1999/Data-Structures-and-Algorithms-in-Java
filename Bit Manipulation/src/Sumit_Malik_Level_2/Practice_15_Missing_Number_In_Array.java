package Sumit_Malik_Level_2;

public class Practice_15_Missing_Number_In_Array {
    // https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
    int MissingNumber(int array[], int n) {
        int ans = 0;
        for (int val : array) {
            ans ^= val;
        }
        for (int i = 1; i <= n; i++) {
            ans ^= i;
        }
        return ans;
    }
}
