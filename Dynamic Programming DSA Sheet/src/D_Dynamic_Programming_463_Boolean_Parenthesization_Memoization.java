import java.util.HashMap;


// https://www.youtube.com/watch?v=bzXM1Zond9U
// https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
public class D_Dynamic_Programming_463_Boolean_Parenthesization_Memoization {
    static int countWays(int N, String S) {
        HashMap<String, Integer> map = new HashMap<>();
        return countTotalWays(S, 0, N - 1, true, map);
    }

    static int countTotalWays(String str, int i, int j, boolean flag, HashMap<String, Integer> res) {
        if (i > j)
            return 0;
        if (i == j) {
            if (flag)
                return str.charAt(i) == 'T' ? 1 : 0;
            else
                return str.charAt(i) == 'F' ? 1 : 0;
        }
        StringBuilder sb = new StringBuilder();

        sb.append(i + " " + j + " " + flag);


        if (res.containsKey(sb.toString()))
            return res.get(sb.toString());

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int leftTrue = countTotalWays(str, i, k - 1, true, res);
            int leftFalse = countTotalWays(str, i, k - 1, false, res);
            int rightTrue = countTotalWays(str, k + 1, j, true, res);
            int rightFalse = countTotalWays(str, k + 1, j, false, res);


            if (str.charAt(k) == '&') {
                if (flag) {
                    ans += leftTrue * rightTrue;
                } else {
                    ans += leftFalse * rightFalse + leftTrue * rightFalse + leftFalse * rightTrue;
                }
            } else if (str.charAt(k) == '|') {
                if (flag) {
                    ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ans += leftFalse * rightFalse;
                }
            } else if (str.charAt(k) == '^') {
                if (flag) {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ans += leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
        }

        res.put(sb.toString(), ans % 1003);
        return ans % 1003;
    }

}
