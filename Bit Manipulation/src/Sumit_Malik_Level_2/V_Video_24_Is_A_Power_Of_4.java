package Sumit_Malik_Level_2;

public class V_Video_24_Is_A_Power_Of_4 {
    // https://leetcode.com/problems/power-of-four/
    public boolean isPowerOfFour(int n) {
        int fact = 0b01010101010101010101010101010101;
        return n > 0 && ((n & (n - 1)) == 0) && (fact & n) > 0;
    }
    // https://practice.geeksforgeeks.org/problems/power-of-four/1
    // https://leetcode.com/problems/power-of-four/submissions/
    int isPowerOfFour(long n)
    {
        while (n > 1) {
            if ((n % 4) != 0)
                return 0;
            n = n / 4;
        }
        return n == 1 ? 1 : 0;
    }
    public boolean isPowerOfFour1(int n) {
        while (n > 1) {
            if ((n % 4) != 0)
                return false;
            n = n / 4;
        }
        return n == 1 ? true : false;
    }
}
