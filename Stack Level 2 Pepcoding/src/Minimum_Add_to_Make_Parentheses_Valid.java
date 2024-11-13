import java.util.Stack;
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class Minimum_Add_to_Make_Parentheses_Valid {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                st.push(s.charAt(i));
            else
            {
                if(st.isEmpty())
                    ans++;
                else
                    st.pop();
            }
        }
        return ans + st.size();
    }
}
