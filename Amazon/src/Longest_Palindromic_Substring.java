//https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1/?category[]=Strings&category[]=Strings&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Stringscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Strings#

public class Longest_Palindromic_Substring {
    static String longestPalindrome(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int start = 0;
        int end = 1;
        int len = 0;
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                }
                else if (g == 1) {
                    if (str.charAt(i) == str.charAt(j))
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                }
                else {
//                    System.out.println(g+"       "+str.charAt(i)+"   "+str.charAt(j)+"   "+i+"    "+j);
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j] && len < (g+1))
                {
                    len = g+1;
                    start = i;
                    end = j+1;
                }
            }
        }
//        for(int i =0;i<dp.length;i++)
//        {
//            for(int j=0;j<dp[0].length;j++)
//            {
//                System.out.print(dp[i][j]+"  ");
//            }
//            System.out.print("\n");
//        }
//        System.out.print("\n");
//        System.out.println("Maximum Length : "+len);
//        System.out.println("Palindromic String : "+str.substring(start,end));
        return str.substring(start,end);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bc"));
    }
}
