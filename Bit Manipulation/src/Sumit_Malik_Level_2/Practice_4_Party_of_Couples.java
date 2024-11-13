package Sumit_Malik_Level_2;

public class Practice_4_Party_of_Couples {
    // https://practice.geeksforgeeks.org/problems/alone-in-couple5507/1
    static int findSingle(int N, int arr[]){
        int ans = 0;
        for(int val : arr)
            ans ^= val;
        return ans;
    }
}
