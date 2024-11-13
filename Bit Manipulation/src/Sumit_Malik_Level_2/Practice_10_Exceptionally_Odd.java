package Sumit_Malik_Level_2;

public class Practice_10_Exceptionally_Odd {
    // https://practice.geeksforgeeks.org/problems/find-the-odd-occurence4820/1
    int getOddOccurrence(int[] arr, int n) {
        int num = 0;
        for (int val : arr)
            num ^= val;
        return num;
    }
}
