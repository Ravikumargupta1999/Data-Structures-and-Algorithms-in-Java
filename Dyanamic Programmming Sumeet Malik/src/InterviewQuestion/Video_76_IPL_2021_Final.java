package InterviewQuestion;

public class Video_76_IPL_2021_Final {
    // https://practice.geeksforgeeks.org/problems/3b47f0ad00f953dd514235ddec54e39fdc297dda/1
    // https://leetcode.com/problems/longest-valid-parentheses/submissions/
    static int findMaxLen(String s) {
        int open = 0;
        int close = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(')
                open++;
            else if(ch == ')')
                close++;
            if(open == close)
                max = Math.max(max,open+close);
            else if(close > open){
                open = 0;
                close = 0;
            }
        }
        open = 0;
        close = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == '(')
                open++;
            else if(ch == ')')
                close++;
            if(open == close)
                max = Math.max(max,open+close);
            else if(close < open){
                open = 0;
                close = 0;
            }
        }
        return max;
    }

}
