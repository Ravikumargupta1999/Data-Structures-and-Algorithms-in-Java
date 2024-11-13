public class Number_of_Digit_One {
    public static void main(String[] args) {
        Number_of_Digit_One a = new Number_of_Digit_One();
        System.out.println(a.countDigitOne(456113445));
    }
    public int countDigitOne(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++) {
//            System.out.println(countOnes(i,0));
            dp[i] = dp[i - 1] + countOnes(i, 0);
        }
        return dp[n];
    }
    int countOnes(int n, int count) {
        if (n == 0)
            return count;
        if (n % 10 == 1) {
            return countOnes(n / 10, count + 1);
        } else
            return countOnes(n / 10, count);

    }

}
