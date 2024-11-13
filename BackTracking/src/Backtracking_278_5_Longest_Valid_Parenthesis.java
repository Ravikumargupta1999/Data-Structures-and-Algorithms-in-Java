import java.util.Stack;

public class Backtracking_278_5_Longest_Valid_Parenthesis {
    // https://www.youtube.com/watch?v=VdQuwtEd10M
    // https://leetcode.com/problems/longest-valid-parentheses/submissions/
    // https://practice.geeksforgeeks.org/problems/longest-valid-parentheses5657/1/
    // Brute Forced Approach
    // TC : O(n^3)
    // SC : O(n)
    public int longestValidParenthesis1(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String s1 = s.substring(i, j + 1);
                if (isValid(s1)) {
                    max = Math.max(s1.length(), max);
                }
            }
        }
        return max;
    }

    static boolean isValid(String string) {
        System.out.println(string);
        Stack<Character> st = new Stack<>();
        for (char ch : string.toCharArray()) {
            if (ch == '(')
                st.push(ch);
            else {
                if (st.isEmpty())
                    return false;
                if (ch == ')' && st.peek() != '(') {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty() ? true : false;
    }

    // Optimized Approach
    // TC : O(n)
    // SC : O(n)
    public int longestValidParentheses2(String s) {
        int max = 0;
        if (s.length() == 0)
            return max;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // Optimized Approach
    // TC : O(n)
    // SC : O(1)
    public int longestValidParentheses3(String s) {
        int open = 0;
        int close = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                open++;
            else if (ch == ')')
                close++;
            if (open == close)
                max = Math.max(max, open + close);
            else if (close > open) { // when checking from left sie close > open then invalid
                open = 0;
                close = 0;
            }
        }
        open = 0;
        close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(')
                open++;
            else if (ch == ')')
                close++;
            if (open == close)
                max = Math.max(max, open + close);
            else if (close < open) {// // when checking from right sie close > open then invalid
                open = 0;
                close = 0;
            }
        }
        return max;
    }


}
