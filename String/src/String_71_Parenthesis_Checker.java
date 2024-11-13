import java.util.Stack;

public class String_71_Parenthesis_Checker {
    // https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1

    public static boolean parenthesisCheck(String str) {
        if (str.length() == 0)
            return false;
        Stack<Character> stack = new Stack<>();
        char ch = str.charAt(0);
        stack.push(ch);


        for (int i = 1; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
                continue;
            }
            char check;
            if (ch == ')') {

                if (stack.empty())
                    return false;
                check = stack.peek();
                if (check == '{' || check == '[')
                    return false;
                stack.pop();
            }
            if (ch == '}') {

                if (stack.empty())
                    return false;
                check = stack.peek();
                if (check == '[' || check == '(')
                    return false;
                stack.pop();

            }
            if (ch == ']') {

                if (stack.empty())
                    return false;
                check = stack.peek();
                if (check == '{' || check == '(')
                    return false;
                stack.pop();
            }
        }
        if (stack.empty())
            return true;
        else
            return false;

    }
}
