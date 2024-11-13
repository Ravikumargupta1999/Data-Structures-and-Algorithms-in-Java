package Package_Started;

import java.util.Scanner;

public class Reverse_a_Number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(reverseNumber(n));
    }

    public static int reverseNumber(int n) {
        int ans = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            ans = ans * 10 + digit;
        }
        return ans;
    }
}
