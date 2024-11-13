package Sumit_Malik_Level_2;

public class Practice_1_Check_Set_Bits {
    // Check set bits
    // https://practice.geeksforgeeks.org/problems/check-set-bits5408/1
    static int isBitSet(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return ((n + 1) & (n)) == 0 ? 1 : 0;
    }
}
