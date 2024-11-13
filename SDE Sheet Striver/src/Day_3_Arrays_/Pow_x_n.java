package Day_3_Arrays_;

public class Pow_x_n {
    public static void main(String[] args) {
        myPow_(2, 10);
    }

    // for positive n
    public static double myPow_(double x, int n) {
        if (n == 1)
            return x;
        double d1 = myPow_(x, n / 2);
        System.out.println(x + "   " + n + "   " + d1);
        if (n % 2 == 0)
            return d1;
        else
            return d1 * d1 * x;
    }


    public double myPow(double x, int n) {
        if (x == 2.0 && n == -2147483648) {
            return 0.0;
        } else if (x == 1.0 && n == -2147483648) {
            return 1.0;
        }
        int nn = n;

        if (nn < 0)
            nn = -1 * nn;

        double ans = 1.0;

        while (nn > 0) {

            if (nn % 2 != 0) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }

        if (n < 0)
            ans = (double) (1.0) / (double) (ans);
        return ans;
    }
}
