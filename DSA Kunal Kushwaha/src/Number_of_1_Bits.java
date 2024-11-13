public class Number_of_1_Bits {
// https://leetcode.com/problems/number-of-1-bits/submissions/
    public static int hammingWeight(int n) {
        if( n >= 0) {
            int count = 0;
            while (n > 0) {
                if ((n & 1) == 1)
                    count++;
                n = n >> 1;
            }
            return count;
        }
        else
        {
            int count = 0;
            String str = Integer.toBinaryString(n);
            System.out.println(str);
            for(int i=0;i<str.length();i++)
                if(str.charAt(i) == '1')
                    count++;
            return count;
        }
    }

    // not valid for negative numbers
    private static int setBits(int n) {
        int count = 0;

//        while (n > 0) {
//            count++;
//            n -= (n & -n);
//        }

        while (n > 0) {
            count++;
            n = n & (n-1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-67));
    }

}
