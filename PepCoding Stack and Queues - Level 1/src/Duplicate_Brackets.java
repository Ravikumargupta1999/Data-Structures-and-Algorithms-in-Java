import java.util.Stack;

public class Duplicate_Brackets {
    public static void main(String[] args) {
        String str = "((a+b)+(c+d))";
        System.out.println(isContainsDuplicate(str));
    }
   // https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
    public static boolean isContainsDuplicate(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(')
                    return true;
                else {
                    while (st.peek() != '(')
                        st.pop();
                    st.pop();
                }
            } else
                st.push(ch);
        }
        return false;
    }
}
