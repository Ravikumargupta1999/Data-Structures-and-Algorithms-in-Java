package Sumit_Malik_Level_2;

public class Practice_13_Change_All_Even_Bits_In_A_Number_To_0 {
    // https://practice.geeksforgeeks.org/problems/change-all-even-bits-in-a-number-to-03253/1
    static long convertEvenBitToZero(long n) {
        for (int i = 0; i < 64; i += 2) {
            int offMask = ~(1 << i);
            n = n & offMask;
        }
        return n;

        // return n&0xAAAAAAAA;
    }

    public static void main(String[] args) {
        System.out.println(convertEvenBitToZero(30));
    }
}
