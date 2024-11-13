package Sumit_Malik_Level_2;

public class V_Video_27_Sum_of_Bit_Differences_Among_All_Pairs {
    // Method - 1;
    // TC : O(n^2)
    static int countBits1(int N, long A[])
    {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    sum += count(A[i] ^ A[j]);

                    // A[i]^A[j] will contain 1 for different value . use kernighans algorithm now
                }
            }
        }
        return sum;
    }

    public static int count(long n) {
        int counter = 0;
        while (n != 0) {
            long rightMostSetBit = (n & -n);
            n -= rightMostSetBit;
            counter++;
        }
        return counter;
    }

    // https://www.youtube.com/watch?v=L_fIn5TM3mM&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=27
    // https://practice.geeksforgeeks.org/problems/find-sum-of-different-corresponding-bits-for-all-pairs4652/1/#
    static int countBits(int n, long arr[]) {
        long res = 0;
        int mod = 1000000007;
        for (int i = 0; i < 32; i++) {
            long countOn = 0;
            for (long val : arr) {
                if ((val & (1 << i)) != 0) {
                    countOn++;
                }
            }
            // long countOff = arr.length - countOn;
            // long diff = countOff * countOn * 2;
            // res += diff;
            res = (res + 2 * countOn * (arr.length - countOn)) % mod;
        }
        return (int) res;
    }

    // https://practice.geeksforgeeks.org/problems/sum-of-bit-differences2937/1
    long sumBitDifferences(int[] arr, int n) {
        long res = 0;
        int mod = 1000000007;
        for (int i = 0; i < 32; i++) {
            long countOn = 0;
            for (long val : arr) {
                if ((val & (1 << i)) != 0) {
                    countOn++;
                }
            }
            long countOff = arr.length - countOn;
            long diff = countOff * countOn * 2;
            res += diff;
        }
        return res;
    }
}
