import java.util.Scanner;

public class StringCountPalindromSubString
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int count = CountPalindrm(str);
        System.out.println(count);
    }
    public static int CountPalindrm(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;
        for (int gap = 0; gap < str.length(); gap++) {
            for (int start = 0, end = gap; end < dp.length; start++, end++) {
                if (gap == 0) {
                    dp[start][end] = true;
                } else if (gap == 1) {
                    if (str.charAt(start) == str.charAt(end)) {
                        dp[start][end] = true;
                    } else {
                        dp[start][end] = false;
                    }
                } else
                {
                    if (str.charAt(start) == str.charAt(end) && dp[start + 1][end - 1] == true)
                    {
                        dp[start][end] = true;
                    }
                    else{
                        dp[start][end] = false;
                    }
                }
                if (dp[start][end]) {
                    //   if(gap != 0)
                    count++;
                }
            }
        }
        return count;
    }
}

