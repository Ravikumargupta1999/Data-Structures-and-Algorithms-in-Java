import java.util.Stack;

public class Valid_Parentheses {
    public static boolean isValid(String s) {
        if(s.length()%2  != 0)
            return false;
        int i = 0;
        Stack<Character> stack = new Stack<>();
        if(s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')')
            return false;
        while ( i < s.length())
        {
            if(s.charAt(i) == ']' || s.charAt(i) == ')' || s.charAt(i) == '}')
            {
                if(stack.size() == 0 )
                    return false;
                if(s.charAt(i) == ']')
                {
                    // System.out.println("Kya hua");
                    if(stack.peek() == '[')
                        stack.pop();
                    else if(stack.peek() == '{' || stack.peek() == '(')
                        return false;
                }
                else if(s.charAt(i) == '}')
                {
                    if(stack.peek() == '{')
                        stack.pop();
                    else if(stack.peek() == '[' || stack.peek() == '(')
                        return false;
                }
                else if(s.charAt(i) == ')')
                {
                    if(stack.peek() == '(')
                        stack.pop();

                    else if(stack.peek() == '{' || stack.peek() == '[')
                        return false;
                }
            }
            else
            {
                stack.push(s.charAt(i));
            }
            i++;
            // System.out.println(stack);
        }
        if(stack.size() != 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("([]{})[]"));
    }
}
