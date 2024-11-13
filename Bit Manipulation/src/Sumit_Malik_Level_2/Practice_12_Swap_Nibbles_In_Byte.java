package Sumit_Malik_Level_2;

public class Practice_12_Swap_Nibbles_In_Byte {

    // https://www.youtube.com/watch?v=mKfMenGD7qE&t=176s
    // https://practice.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1/?page=2&difficulty[]=-1&category[]=Bit%20Magic&sortBy=submissions#
    static int swapNibbles1(int n) {
        int rightNibble = ((n & 0x0F) << 4);
        int leftNibble = ((n & 0xF0) >> 4);
        return leftNibble | rightNibble;
    }
}
