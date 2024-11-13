//https://practice.geeksforgeeks.org/problems/modular-exponentiation-for-large-numbers5537/1/?company[]=Google&company[]=Google&difficulty[]=1&page=1&query=company[]Googledifficulty[]1page1company[]Google#

public class Modular_Exponentiation_for_large_numbers {
    public static long PowMod(long x, long n, long m) {
        long ans = (long) Math.pow(x, n);
        System.out.println(ans);
        ans = ans % m;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(PowMod(18,17,2));
    }
}
