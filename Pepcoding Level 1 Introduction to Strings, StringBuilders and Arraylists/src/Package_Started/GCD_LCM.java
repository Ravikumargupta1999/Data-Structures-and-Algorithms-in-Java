package Package_Started;

public class GCD_LCM {
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, b);
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    // Driver method
    public static void main(String[] args) {
        int a = 3, b = 4;
        System.out.println("LCM of " + a + " and " + b + " is " + gcd(a, b));
        System.out.println("LCM of " + a + " and " + b + " is " + lcm(a, b));
    }
}
