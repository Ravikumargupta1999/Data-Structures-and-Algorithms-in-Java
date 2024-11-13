package Sumit_Malik_Level_2;

import java.util.*;

public class V_Video_22_Toggle_Bits_in_a_Range {
    // https://www.youtube.com/watch?v=v7pUZw-ZOYU&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=22
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int left = scn.nextInt();
        int right = scn.nextInt();
        // https://www.geeksforgeeks.org/copy-set-bits-in-a-range/
        int mask = (1 << (right - left + 1)) - 1;
        mask = ((mask << (left - 1)) & a);
        b |= mask;
        System.out.println(b);
        System.out.println(toggleBits(a,left,right));

    }

    // https://practice.geeksforgeeks.org/problems/toggle-bits-given-range0952/1/#
    static int toggleBits(int n, int left, int right) {
        int mask = 1;
        mask = mask << (right - left + 1);
        mask = mask - 1;
        mask = mask << (left - 1);

        n = n ^ mask;
        return n;
    }
}
