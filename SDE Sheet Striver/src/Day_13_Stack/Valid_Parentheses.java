package Day_13_Stack;

import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;
                if (ch == ']') {
                    if (stack.peek() == '{' || stack.peek() == '(')
                        return false;
                    else
                        stack.pop();
                } else if (ch == '}') {
                    if (stack.peek() == '[' || stack.peek() == '(')
                        return false;
                    else
                        stack.pop();
                } else {
                    if (stack.peek() == '[' || stack.peek() == '{')
                        return false;
                    else
                        stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
