import java.util.HashSet;
import java.util.Stack;

// https://leetcode.com/problems/remove-outermost-parentheses/submissions/
public class Remove_Outermost_Parentheses {
    public static String removeOuterParentheses(String s) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.size() == 0) {
                set.add(i);
            }
            char ch = s.charAt(i);
            if (ch == '(')
                st.add(ch);
            else {
                if (st.size() == 1) {
                    st.pop();
                    set.add(i);
                } else {
                    st.pop();
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String removeOuterParentheses1(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '(') {
                if (st.size() != 0)
                    sb.append(ch);
                st.add(ch);
            } else {
                if (st.size() != 1) {
                    sb.append(ch);
                }
                st.pop();
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses1("()()"));
    }
}
