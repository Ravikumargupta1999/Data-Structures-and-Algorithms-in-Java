//https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1#

public class Video_10_Count_Subsequences {

    public int fun(String s) {
        long p = 1000000007;
        long a = 0;
        long ab = 0;
        long abc = 0;
        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == 'a') {
                a = a % p;
                a = (2 * a + 1) % p;
            } else if (s.charAt(i) == 'b') {
                a = a % p;
                ab = ab % p;
                ab = (2 * ab + a) % p;
            } else if (s.charAt(i) == 'c') {
                ab = ab % p;
                abc = abc % p;
                abc = (2 * abc + ab) % p;
            }
        }
        int ans = (int) abc;
        return ans;
    }

}
