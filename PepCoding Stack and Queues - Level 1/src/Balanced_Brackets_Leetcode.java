import java.util.Stack;

public class Balanced_Brackets_Leetcode {
    public static void main(String[] args) {
        System.out.println(isBalanced("{{}{}}"));
    }

    public static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == '}') {
                boolean val = handleClosing(st,'{');
                if(!val)
                    return val;

            } else if (ch == ')') {
                boolean val = handleClosing(st,'(');
                if(!val)
                    return val;
            } else if (ch == ']') {
                boolean val = handleClosing(st,'[');
                if(!val)
                    return val;
            } else {

            }
        }
        if (st.size() == 0)
            return true;
        return false;
    }

    static boolean handleClosing(Stack<Character> st, char ch) {
        if (st.size() == 0)
            return false;
        else if (st.peek() != ch)
            return false;
        else {
            st.pop();
            return true;
        }
    }
}
