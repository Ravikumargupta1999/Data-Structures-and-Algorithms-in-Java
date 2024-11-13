package Sumit_Malik_Level_2;

public class Practice_9_Set_kth_bit {
    // https://practice.geeksforgeeks.org/problems/set-kth-bit3724/1
    static int setKthBit(int N,int K){
        int onMask = (1 << K);
        return N | onMask;
    }
}
