package Recursion;

public class Recursion_4_Power {
    public static int powerOfX(int x, int n) {
        if (n == 1)
            return x;
        return powerOfX(x, n - 1);
    }
}
