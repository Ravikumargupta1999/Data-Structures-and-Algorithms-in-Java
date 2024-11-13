public class Recursion9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(566665));
    }
    //https://leetcode.com/problems/palindrome-number/submissions/
    public static boolean isPalindrome(int n)
    {
        return n == reverse(n,0);
    }
    public static int reverse(int n, int num) {
        if (n == 0)
            return num;
        num = num * 10 + n % 10;
        return reverse(n / 10, num);
    }
}
