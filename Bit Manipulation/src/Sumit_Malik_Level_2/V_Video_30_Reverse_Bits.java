package Sumit_Malik_Level_2;

public class V_Video_30_Reverse_Bits {
    public static void main(String[] args) {
        System.out.println(reverseBits(13));
    }
    // PepCoding
    public static int reverseBits(int n)
    {
        boolean flag = false;
        int j = 0;
        int num = 0;
        int rev = 0;
        for (int i = 31; i >= 0; i--) {

            int mask = (1 << i);

            if (flag) {
                if ((n & mask) != 0) {
                    // System.out.print(1);
                    int smask = (1 << j);
                    rev |= (smask);
                } else {
                    // System.out.print(0);
                }
                j++;
            } else {
                if ((n & mask) != 0) {
                    flag = true;
                    // System.out.print(1);
                    int smask = (1 << j);
                    rev |= (smask);
                    j++;
                }
            }
        }
        // System.out.println("");
        return rev;
    }

    // https://practice.geeksforgeeks.org/problems/reverse-bits-1611130171/1/#
    // Only Accepted on GFG not on leetcode
    public static int reverseBits1(int n) {
        String res = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        sb.append(res);
        sb.reverse();
        String ans = sb.toString();
        int fin = Integer.parseInt(ans, 2);
        return fin;
    }

    // https://leetcode.com/problems/reverse-bits/
    // Only Accepted on Leetcode
    // you need treat n as an unsigned value
    public int reverseBits3(int n) {
        int sum = 0;

        int mask = 1;

        for (int pow = 31; pow >= 0; pow--) {

            sum = sum + ((n & mask) << pow);

            n >>= 1;

        }

        return sum;
    }

}
