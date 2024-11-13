import java.util.ArrayList;
import java.util.List;

public class Video_15_Generate_Parentheses {

    // basically for every n there will be output equal to catalan number

    // https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1
    // https://leetcode.com/problems/generate-parentheses/submissions/
    public List<String> generateParenthesis(int n) {
        List<String> output_str = new ArrayList<>();
        backtrack(output_str, "", 0, 0, n);
        return output_str;
    }

    // First way of backtrack
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
    // second way of backtrack
    public void Parenthesis(int n, int op, int cl, String str, List<String> list) {
        Boolean f1 = false;

        if (cl < op) {
            f1 = true;
            Parenthesis(n, op, cl + 1, str + ")", list);
        }
        if (op < n) {
            f1 = true;
            Parenthesis(n, op + 1, cl, str + "(", list);
        }
        if (!f1)
            list.add(str);
    }
}
