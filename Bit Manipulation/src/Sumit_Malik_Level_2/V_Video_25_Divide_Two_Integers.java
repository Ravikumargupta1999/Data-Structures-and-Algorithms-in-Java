package Sumit_Malik_Level_2;

public class V_Video_25_Divide_Two_Integers {
    // https://www.youtube.com/watch?v=m4L_5qG4vG8
    // https://leetcode.com/problems/divide-two-integers/submissions/
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1)
            return 2147483647;
        if (divisor == 1 || divisor == -1) {
            if (divisor == -1)
                return dividend * (-1);
            return dividend;
        }
        boolean negative = (dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int count = 0;
        while (dividend - divisor >= 0) {
            count++;
            dividend -= divisor;
        }
        return negative ? -count : count;
    }

    public static int divide1(int dividend, int divisor) {
        if (dividend == (1 << 31) && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;

        while (dividend - divisor >= 0) {
            int count = 0;
//            System.out.println(dividend + "   " + (divisor << 1 << count)+"   "+count);
            while (dividend - (divisor << (1 << count)) >= 0) {
//                System.out.println(dividend + "   " + (divisor << 1 << count)+"   "+count);
                count++;
            }
//            System.out.println(dividend + "   " + (divisor << 1 << count)+"   "+count);
//            System.out.println(1<<count);
            result += (1 << count);
            dividend -= (divisor << count);
//            System.out.println("");
        }
        return sign ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(divide1(30, 3));
    }
}
