package Sumit_Malik_Level_2;

public class V_Video_9_All_Repeating_Except_Two {
    // https://leetcode.com/problems/single-number-iii/
    // https://practice.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1#
    // https://www.youtube.com/watch?v=pnx5JA9LNM4&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=9
//    https://www.youtube.com/watch?v=pnx5JA9LNM4&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=9
    public int[] twoOddNum(int[] arr, int N) {
        int xxroy = 0;
        for (int val : arr)
            xxroy = xxroy ^ val;

        int rightMostSetBit = xxroy & -xxroy;
        int x = 0;
        int y = 0;

        for (int val : arr)
            if ((val & rightMostSetBit) == 0)
                x = x ^ val;
            else
                y = y ^ val;
        int[] arr1 = new int[2];

        if (x < y) {
            arr1[0] = y;
            arr1[1] = x;
        } else {
            arr1[0] = x;
            arr1[1] = y;
        }
        return arr1;
    }


}
