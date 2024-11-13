import java.security.acl.LastOwnerException;

public class Power_Of_a_Raise_to_b {
    static long power(int a, int b) {

        long ans = 1;
        while (b > 0) {
           if(( b & 1) == 1)
           {
               ans *= a;
           }
           a *= a;
           b = b >> 1;
        }
        return ans;
    }
    public double myPow(double a, int b) {
        double ans = 1;
        while (b > 0) {
            if(( b & 1) == 1)
            {
                ans *= a;
            }
            a *= a;
            b = b >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(power(3, 5));
    }
}
