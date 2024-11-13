import java.security.acl.LastOwnerException;

// https://practice.geeksforgeeks.org/problems/division-without-using-multiplication-division-and-mod-operator/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&difficulty[]=1&page=1&query=category[]Bit%20Magicdifficulty[]1page1category[]Bit%20Magic

public class Divide_Two_Integer_LeetCode {
    public static long divide(long dividend, long divisor)
    {
        if(dividend == (1 << 63) && divisor == -1)
            return Long.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        long result = 0;

        while (dividend - divisor >= 0)
        {
            long count =0;
            while (dividend - (divisor << 1 << count) >= 0)
                count ++;
            result += (1 << count);
            dividend -= (divisor << count);
        }
        return sign ? result : -result;

    }
}
