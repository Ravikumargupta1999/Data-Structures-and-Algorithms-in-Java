package Sumit_Malik_Level_2;

public class V_Video_16_XOR_of_Sum_of_All_Pairs_in_an_Array {
    public static long solution(int[] arr) {
        long ans = 0;
        for (int val : arr)
            ans = ans ^ val;
        return 2 * ans;
    }

    // https://practice.geeksforgeeks.org/problems/sum-of-xor-of-all-pairs0723/1
    // https://www.youtube.com/watch?v=10sMnEraOBs&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=14
    public static long solution1(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            long ans = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                ans = (arr[i] ^ arr[j]);
                sum = sum + ans;
            }
        }
        return sum;
    }

}
