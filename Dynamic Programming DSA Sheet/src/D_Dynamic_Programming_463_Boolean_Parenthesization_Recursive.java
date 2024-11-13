public class D_Dynamic_Programming_463_Boolean_Parenthesization_Recursive {
    // https://www.youtube.com/watch?v=pGVguAcWX4g&t=1988s
    // TLE
    // https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
    static int SolveRecursive(String s, int i, int j, boolean isTrue) {
        //base condition
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lT = SolveRecursive(s, i, k - 1, true);
            int lF = SolveRecursive(s, i, k - 1, false);
            int rT = SolveRecursive(s, k + 1, j, true);
            int rF = SolveRecursive(s, k + 1, j, false);

            //now we will check for each operator (&, |, ^)
            if (s.charAt(k) == '&') {
                if (isTrue) {
                    ans += (lT * rT);   //both should be true
                } else {
                    ans += (lF * rT) + (lT * rF) + (lF * rF);   // any one / both should be false
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue) {
                    ans += (lT * rT) + (lT * rF) + (lF * rT);   //any one should be true
                } else {
                    ans += (lF * rF);  //both should be false
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue) {
                    ans += (lT * rF) + (lF * rT);    //xor condition
                } else {
                    ans += (lT * rT) + (lF * rF);
                }
            }
        }
        return ans;
    }

    static int countWays(int N, String S) {
        return SolveRecursive(S, 0, N - 1, true);
    }

    public static void main(String[] args) {

        String s = "T|T&F^T";

        System.out.println(countWays(s.length(), s));

    }
}
