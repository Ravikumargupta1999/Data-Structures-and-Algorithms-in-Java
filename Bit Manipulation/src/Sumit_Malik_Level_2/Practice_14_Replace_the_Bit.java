package Sumit_Malik_Level_2;

public class Practice_14_Replace_the_Bit {
    // https://practice.geeksforgeeks.org/problems/replace-the-bit3212/1
    static int replaceBit(int n, int k) {
        if (Integer.toBinaryString(n).length() < k)
            return n;
        k = Integer.toBinaryString(n).length() - k + 1;

        if ((n & (1 << (k - 1))) > 0) {

            n = (n & ~(1 << (k - 1)));

        }
        return n;
    }

    static int replaceBit1(int n, int k){
        int length = 0;
        // loop to find first set bit from leftor
        // length of binary
        for (int i = 31; i >= 0; i--) {
            int checkMask = (1 << i);
            if ((n & checkMask) != 0) {
                length = i + 1;
                break;
            }
        }
        // System.out.println(length);
        // System.out.println(Integer.toBinaryString(n));
        if (length == 0)
            return n;

        // kth position from right
        k = length - k ;

        // System.out.println(k);

        // program to off a bit
        int offMask = ~(1 << k);
        return n & offMask;
    }
    public static void main(String[] args) {
        System.out.println(replaceBit1(13, 2));
    }
}
