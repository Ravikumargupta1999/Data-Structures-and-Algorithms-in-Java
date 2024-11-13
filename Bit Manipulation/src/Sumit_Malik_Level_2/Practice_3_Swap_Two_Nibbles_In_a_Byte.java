package Sumit_Malik_Level_2;

public class Practice_3_Swap_Two_Nibbles_In_a_Byte {
    // Swap two nibbles in a byte
    // https://practice.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1/?page=3&category[]=Bit%20Magic&sortBy=submissions#
    static int swapNibbles(int N) {
        String str = Integer.toBinaryString(N);
        for (int i = str.length(); i < 8; i++)
            str = "0" + str;
//        System.out.println(str+"   "+str.length());
        StringBuilder sb = new StringBuilder();
        for (int i =  4; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        for (int i = 0; i < 4; i++) {
            sb.append(str.charAt(i));
        }
//        System.out.println(sb);
        return Integer.parseInt(sb.toString(), 2);
    }
    // https://www.youtube.com/watch?v=mKfMenGD7qE&t=176s
    // https://practice.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1/?page=2&difficulty[]=-1&category[]=Bit%20Magic&sortBy=submissions#
    static int swapNibbles1(int n) {
        int rightNibble = ((n & 0x0F) << 4);
        int leftNibble =((n & 0xF0) >> 4);
        return leftNibble | rightNibble;
    }
    public static void main(String[] args) {
        System.out.println(swapNibbles(19));
    }
}
