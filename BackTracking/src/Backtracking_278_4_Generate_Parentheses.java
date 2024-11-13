import java.util.ArrayList;
import java.util.List;

public class Backtracking_278_4_Generate_Parentheses {
    // https://leetcode.com/problems/generate-parentheses/
    // https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/0/?page=3&query=page3
    public List<String> generateParenthesis(int n) {
        List<String> output_str = new ArrayList<>();
        backtrack(output_str, "", 0, 0, n);
        return output_str;
    }

    public void backtrack(List<String> output_str, String curr_str, int open, int close, int n) {
        if (curr_str.length() == n * 2) {
            output_str.add(curr_str);
            return;
        }
        if (open < n)
            backtrack(output_str, curr_str + "(", open + 1, close, n);
        if (close < open)
            backtrack(output_str, curr_str + ")", open, close + 1, n);
    }
}
