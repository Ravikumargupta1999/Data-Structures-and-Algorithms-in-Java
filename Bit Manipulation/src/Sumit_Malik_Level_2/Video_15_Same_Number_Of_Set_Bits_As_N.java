package Sumit_Malik_Level_2;

import java.util.Scanner;

public class Video_15_Same_Number_Of_Set_Bits_As_N {
    // https://www.geeksforgeeks.org/number-set-bits-n/
    // https://www.youtube.com/watch?v=DMTw6pP5zTg&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=15
    static long smallerNumWithSameSetBits(long n, int k, int i) {
        if (i == 0)
            return 0;
        long mask = 1L << i;

        if ((n & mask) == 0) {
            return smallerNumWithSameSetBits(n, k, i - 1);
        } else {
            long res1 = smallerNumWithSameSetBits(n, k - 1, i - 1);
            long res0 = nCr(i, k);
            return res1 + res0;
        }

    }

    public static int countSetBits(int n) {
        int res = 0;
        while (n > 0) {
            long rsb = n & -n;
            n -= rsb;
            res++;
        }
        return res;
    }

    public static long nCr(long n, long r) {
        if (n < r) {
            return 0L;
        }
        long res = 1L;
        for (long i = 0L; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = countSetBits(n);
        System.out.println(smallerNumWithSameSetBits(n, k, 63));
    }
}
