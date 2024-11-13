import java.util.Stack;

public class Balanced_Brackets {
    //https://leetcode.com/problems/valid-parentheses/submissions/
    //https://www.youtube.com/watch?v=p-RbQyQevTQ&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=4
    public static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else
            {
                if(ch == '}')
                {
                    if(st.size() == 0)
                        return "N0";
                    if(st.peek() != '{')
                        return "NO";
                    st.pop();
                }
                else if(ch == ')')
                {
                    if(st.size() == 0)
                        return "N0";
                    if(st.peek() != '(')
                        return "NO";
                    st.pop();

                }
                else if(ch == ']')
                {
                    if(st.size() == 0)
                        return "N0";
                    if(st.peek() != '[')
                        return "NO";
                    st.pop();
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        String str = "{}{()}{{}}";
        System.out.println(isBalanced("{}"));
        System.out.println(isBalanced("}([[{)[]))]{){}["));
        System.out.println(isBalanced("{]]{()}{])"));
        System.out.println(isBalanced("(){}"));
        System.out.println(isBalanced("{}{()}{{}}"));
    }


}
//{}
//        }([[{)[]))]{){}[
//        {]]{()}{])
//        (){}
//        {}{()}{{}}