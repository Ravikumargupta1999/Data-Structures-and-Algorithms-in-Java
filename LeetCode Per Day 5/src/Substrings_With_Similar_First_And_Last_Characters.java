public class Substrings_With_Similar_First_And_Last_Characters {
    int countSubstringWithEqualEnds(String s) {
        int count = 0;
        int[] dp = new int[26];
        for (char ch : s.toCharArray()){
            count += (1 + dp[ch-'a']);
            dp[ch-'a']++;
        }
        return count;
    }
}
