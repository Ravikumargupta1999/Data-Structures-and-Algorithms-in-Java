package Sumit_Malik_Level_2;

public class V_Video_23_Power_of_Two {
    // https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1#
    // https://www.youtube.com/watch?v=I80Ovvi_nRU&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=23
    public static boolean isPowerOfTwo(long n) {
        if (n == 0)
            return false;
        long val = n & (n - 1);
        return val == 0 ? true : false;
    }
    // https://leetcode.com/problems/power-of-two/submissions/
    public boolean isPowerOfTwo(int n) {
        return n == 0 || n ==  -2147483648 ?false :((n &(n-1)) == 0 ? true : false);
    }
    public static void main(String[] args) {
//        System.out.println(isPowerOfTwo(109));
    }
}
