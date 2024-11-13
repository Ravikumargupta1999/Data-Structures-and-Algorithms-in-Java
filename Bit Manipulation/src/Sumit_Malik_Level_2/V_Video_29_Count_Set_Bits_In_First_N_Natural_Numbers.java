package Sumit_Malik_Level_2;

public class V_Video_29_Count_Set_Bits_In_First_N_Natural_Numbers {

    // Brute force Use kernighan's algorithm for all integer from 1 to N
    // https://practice.geeksforgeeks.org/problems/sherlock-and-his-enemies2304/1/
    // https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
    static int countBits(int n) {
        if (n == 0)
            return 0;
        int x = largestPowerOf2inRange(n);

        int btill2x = x * (1 << (x - 1));
        int msb2ton = n - (1 << x) + 1;
        int rest = n - (1 << x);
        return btill2x + msb2ton + countBits(rest);

    }

    public static int largestPowerOf2inRange(int n) {
        int x = 0;
        while ((1 << x) <= n)
            x++;
        return x - 1;

    }

}
