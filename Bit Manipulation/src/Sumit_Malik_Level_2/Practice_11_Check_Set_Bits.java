package Sumit_Malik_Level_2;
// https://practice.geeksforgeeks.org/problems/check-set-bits5408/1
public class Practice_11_Check_Set_Bits {
    static int isBitSet(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return ((n + 1) & (n)) == 0 ? 1 : 0;
    }
}
