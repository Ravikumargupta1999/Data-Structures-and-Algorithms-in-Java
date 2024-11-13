import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
// https://www.youtube.com/watch?v=YHSjvswCXC8
public class D_Dynamic_Programming_451_Count_Palindromic_Subsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "mbcgepnkdqemhmkuqosgeonbcrphobcmbhrgppkfpdqckigsomktpsurknsospighufulqijcupisnuqcqfpuckrndmqeeklqfcrfnemeghmnlunlpslncqllmbebnoudihgpigrfbrqbcurmqnfroheqltkbnpocousjepehgppmblodppsqrglprtekmsqlqekhjseotocgkfcrkssmmenhitupdcoujscnetbrrcdoctqdfssupfnuolrobckseuromqsuoctmnbudnthrctndtrnietrkqbropugptpuhclftohuendhhnpnhqqkmksigbcrtrtjtmhonnumnnupgtntdhefushmrshselrdfqnoddmqqhjrjtknmokrlgdrcomnbjdlcothrhgsljreflusnnnrkckstoluhduguicfomgjkorgmujoonekscbikeshbqfqfrbcmspqphujltqebostmbkunhhhqmdqdqmfsbek";
        long value = countPalindrom(str);
        System.out.println(value);
    }

    public static long countPalindrom(String str) {
        long mod = 1000000007;
        long[][] dp = new long[str.length()][str.length()];
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) {
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(j);
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = ch1 == ch2 ? 3 : 2;
                } else {
                    if (ch1 == ch2)
                        dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % mod;
                    else {
                        long a = (dp[i][j - 1] + dp[i + 1][j]) % mod;
                        long b = dp[i + 1][j - 1];
                        dp[i][j] = ((a - b) % mod + mod) % mod;
                    }
                }
            }
        }
        return dp[0][str.length() - 1];
    }
}
