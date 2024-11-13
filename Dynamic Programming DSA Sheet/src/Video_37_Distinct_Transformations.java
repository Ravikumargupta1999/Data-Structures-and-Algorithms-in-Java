public class Video_37_Distinct_Transformations {
    // Recursion
    int findTotalTransformation(String source, String target, int si, int ti) {
        if (si == source.length()) {
            if (ti < target.length())
                return 0;
            else
                return 1;
        } else if (ti == target.length())
            return 1;

        char c1 = source.charAt(si);
        char c2 = target.charAt(ti);

        int total = 0;
        if (c1 != c2)
            total += findTotalTransformation(source, target, si + 1, ti);
        else
            total += (findTotalTransformation(source, target, si + 1, ti) + findTotalTransformation(source, target, si + 1, ti + 1));
        return total;
    }

    // https://www.geeksforgeeks.org/ways-transforming-one-string-removing-0-characters/
    public static int totalWays(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1) {
                    dp[i][j] = 1;
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else {
                    char c1 = t.charAt(i);
                    char c2 = s.charAt(j);
                    if (c1 != c2) {
                        dp[i][j] = dp[i][j + 1];
                    } else {
                        dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(totalWays("aabba", "ab"));
    }
}
