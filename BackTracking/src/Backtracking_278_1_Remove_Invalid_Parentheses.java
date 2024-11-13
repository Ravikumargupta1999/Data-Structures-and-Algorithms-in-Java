import java.util.*;

public class Backtracking_278_1_Remove_Invalid_Parentheses {
    public List<String> removeInvalidParentheses(String str) {

        HashSet<String> ans = new HashSet<>();
        int minimumRemoval = getMinimumRemoval(str);
        solution(str, minimumRemoval,ans);


        List<String> result = new ArrayList<>();
        Iterator value = ans.iterator();
        while (value.hasNext()) {
            String temp = value.next().toString();
            result.add(temp);
        }
        return result;

    }

    public static void solution(String str, int mra,HashSet<String> ans) {
        if (mra == 0) {
            int minimumRemovalNow = getMinimumRemoval(str);
            if (minimumRemovalNow == 0) {
                if (!ans.contains(str)) {

                    ans.add(str);
                }
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            solution(left + right, mra - 1,ans);
        }
    }

    public static int getMinimumRemoval(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0) {
                    st.push(ch);
                } else if (st.peek() == ')') {
                    st.push(ch);
                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();
    }
}
