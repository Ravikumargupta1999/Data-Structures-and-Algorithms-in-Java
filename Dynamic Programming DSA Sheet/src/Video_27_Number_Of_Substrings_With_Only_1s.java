public class Video_27_Number_Of_Substrings_With_Only_1s {
    // https://leetcode.com/problems/number-of-substrings-with-only-1s/
    public int numSub(String s) {
        int len = 0;
        int res = 0;
        int mod = 1000000007;
        for (char ch : s.toCharArray()) {
            if (ch == '0')
                len = 0;
            else
                len++;

            res = res % mod + len % mod;

        }
        return res % mod;
    }
    // https://practice.geeksforgeeks.org/problems/count-substrings0427/1
    int countSubstr(String s) {
        int len = 0;
        int res = 0;
        int mod = 1000000007;
        for (char ch : s.toCharArray()) {

            if (ch == '1') {
                res = res % mod + len % mod;
                len++;
            }


        }
        return res % mod;
    }
}
