public class Recursion5SumOfDigit {
    public static void main(String[] args) {
        System.out.println(isDigitSumPalindrome(56));
    }

    static boolean isDigitSumPalindrome(int n) {
        int num = sumOfDigit(n, 0);
//        System.out.println(n + "   " + num);
        return checkPaindromic(num);
    }

    static int sumOfDigit(int n, int sum) {
        if (n == 0)
            return sum;
        int a = n % 10;
        return sumOfDigit(n / 10, a + sum);
    }

    static boolean checkPaindromic(int n) {
        String str = Integer.toString(n);
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
