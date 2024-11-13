package One;

import java.util.Stack;
// https://leetcode.com/problems/valid-parentheses/submissions/

// Try this one
// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
public class Valid_Parentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0 )
            return false;
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()){
            System.out.println(ch+"   "+st);
            if(ch == '{' || ch == '(' || ch == '[')
                st.push(ch);
            else if(ch == ')'){
                if(st.isEmpty())
                    return false;
                else if(st.peek() != '(')
                    return false;
                st.pop();
            }
            else if(ch == '}'){
                if(st.isEmpty())
                    return false;
                else if(st.peek() != '{')
                    return false;
                st.pop();
            }
            else if(ch == ']'){
                if(st.isEmpty())
                    return false;
                else if(st.peek() != '[')
                    return false;
                st.pop();
            }
        }
        // Important base case at the end stack should be empty
        return st.isEmpty() && true;
    }

    public static void main(String[] args) {
        System.out.println(new Valid_Parentheses().isValid("([)]"));
    }
}
