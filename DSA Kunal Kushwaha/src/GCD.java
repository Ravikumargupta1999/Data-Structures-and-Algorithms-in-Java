import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/lcm-and-gcd4516/1
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(14, 67));
        long a = 14;
        long b = 8;
        System.out.println(Arrays.toString(lcmAndGcd(a,b)));
    }

    static Long[] lcmAndGcd(Long a, Long b) {
        Long[] arr = new Long[2];
        arr[1] = gcd(a, b);
        arr[0] = (a * b) / arr[1];
        return arr;
    }

    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
