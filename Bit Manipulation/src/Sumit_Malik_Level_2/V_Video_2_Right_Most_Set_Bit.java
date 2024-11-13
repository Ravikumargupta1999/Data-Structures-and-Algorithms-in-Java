package Sumit_Malik_Level_2;

public class V_Video_2_Right_Most_Set_Bit {
    public static void main(String[] args) {
        int n = 10;
        int rightMostSetBit = n & -n;
        System.out.println(rightMostSetBit+"    "+Integer.toBinaryString(rightMostSetBit));
    }
    // https://practice.geeksforgeeks.org/problems/find-first-set-bit-1587115620/1
    // Brute Force
    public static int getFirstSetBit(int n) {
        String str = Integer.toBinaryString(n);
        int pos = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1')
                return pos;
            pos++;
        }
        return 0;
    }

    // https://www.youtube.com/watch?v=XcSr6TIMl7w&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=2
    public static int getFirstSetBit1(int n) {
        int rightMostSetBit = n & -n;
        System.out.println(Integer.toBinaryString(rightMostSetBit));
        String str = Integer.toBinaryString(rightMostSetBit);
        int pos = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1')
                return pos;
            pos++;
        }
        return 0;
    }
    // https://leetcode.com/problems/number-of-1-bits/
    public int hammingWeight(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        int count = 0;
        for (char ch : sb.toString().toCharArray()){
            if(ch == '1')
                count++;
        }
        return count;
    }
}
