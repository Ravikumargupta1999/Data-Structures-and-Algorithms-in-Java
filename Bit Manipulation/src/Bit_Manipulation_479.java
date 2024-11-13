public class Bit_Manipulation_479 {
    public int divide(int dividend, int divisor) {

        if (dividend == (1 << 31) && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;

        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << (1 << count)) >= 0)
                count++;
            result += (1 << count);
            dividend -= (divisor << count);
        }
        return sign ? result : -result;

    }

    public static long divide1(long dividend, long divisor) {
        // https://practice.geeksforgeeks.org/problems/division-without-using-multiplication-division-and-mod-operator/1/#
        int sign = (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        long quotient = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int power = 0;
            while (dividend - (divisor << power) >= 0) {
//                System.out.println((divisor << power));
                power++;
            }
            power--;
//            System.out.println("");
            quotient += (1 << power);
//            System.out.println("Quotient  "+quotient);
            dividend -= (divisor << power);

//            System.out.println(dividend + "    " + power + "   " + (divisor << power) + "    " + (1 << power));
//            System.out.println("\n\n\n");
        }

        return sign == -1 ? -quotient : quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide1(-40, 8));
    }
}
// https://practice.geeksforgeeks.org/problems/division-without-using-multiplication-division-and-mod-operator/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&difficulty[]=1&page=1&query=category[]Bit%20Magicdifficulty[]1page1category[]Bit%20Magic
// https://www.youtube.com/watch?v=m4L_5qG4vG8