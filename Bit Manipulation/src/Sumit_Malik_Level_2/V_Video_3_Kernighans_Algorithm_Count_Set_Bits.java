package Sumit_Malik_Level_2;

public class V_Video_3_Kernighans_Algorithm_Count_Set_Bits {
    // Kernighan's Algorithm
    // https://www.youtube.com/watch?v=I475waWiTK4&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=3
    // https://practice.geeksforgeeks.org/problems/set-bits0143/1
    // https://leetcode.com/problems/number-of-1-bits/submissions/
    public static int count(int n) {
        int counter = 0;
        while (n != 0) {
            int rightMostSetBit = (n & -n);
            n = n - rightMostSetBit;
            counter++;
        }
        return counter;
    }
}
