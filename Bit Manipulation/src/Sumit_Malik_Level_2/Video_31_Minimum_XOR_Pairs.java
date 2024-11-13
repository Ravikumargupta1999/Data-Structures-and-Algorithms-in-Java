package Sumit_Malik_Level_2;

import java.util.Arrays;

public class Video_31_Minimum_XOR_Pairs {
    static int minxorpair(int N, int arr[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(min, arr[i] ^ arr[j]);
            }
        }
        return min;
    }

    // https://www.youtube.com/watch?v=OZ2jghS0t24&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=31
    // https://practice.geeksforgeeks.org/problems/minimum-xor-value-pair/0/#
    static int minXorPair(int n, int[] a) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, a[i] ^ a[i + 1]);
        }
        return min;
    }
}
