package Sumit_Malik_Level_2;

public class V_Video_21_Minimum_Flips_to_make_A_equals_B {
    // https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1
    // https://leetcode.com/problems/minimum-bit-flips-to-convert-number/submissions/
    int countMinFlip(int a,int b){
        return countSetBits(a^b);
    }
    public static int countSetBits(int n) {
        int counter = 0;
        while (n != 0) {
            int rightMostSetBit = (n & -n);
            n -= rightMostSetBit;
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new V_Video_21_Minimum_Flips_to_make_A_equals_B().countMinFlip(5,4));
    }
}
