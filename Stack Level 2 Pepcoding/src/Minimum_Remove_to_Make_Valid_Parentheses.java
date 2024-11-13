import java.util.HashSet;
import java.util.Stack;
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/
public class Minimum_Remove_to_Make_Valid_Parentheses {
    // Khud la logic
    public String minRemoveToMakeValid(String s) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.add(i);
            else if(ch == ')'){
                if(st.size() > 0 && s.charAt(st.peek()) == '(')
                {
                    st.pop();
                }
                else
                {
                    set.add(i);
                }
            }
        }
        while (!st.isEmpty())
            set.add(st.pop());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
