import java.util.Scanner;
import java.util.Stack;
// https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
// https://www.youtube.com/watch?v=QZOLb0xHB_Q&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=18
public class S_Stack_Queue_301_Balanced_Parenthesis_Checker {
    static boolean ispar(String string) {
        Stack<Character> st = new Stack<>();
        for (char ch : string.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (st.isEmpty())
                    return false;
                if (ch == ')' && st.peek() != '(') {
                    return false;
                } else if (ch == '}' && st.peek() != '{')
                    return false;
                else if (ch == ']' && st.peek() != '[')
                    return false;
                st.pop();
            }
        }
        return st.isEmpty() ? true : false;
    }

    public static boolean Are_Pair(char ope, char clo) {
        if (ope == '(' && clo == ')')
            return true;
        else if (ope == '[' && clo == ']')
            return true;
        else if (ope == '{' && clo == '}')
            return true;
        else
            return false;
    }

    public static boolean areParenthesisBalanced(String exp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char s = exp.charAt(i);
            if ((exp.charAt(i) == '(') || (exp.charAt(i) == '{') || (exp.charAt(i) == '[')) {
                stack.push(exp.charAt(i));
            } else if ((exp.charAt(i) == ')') || (exp.charAt(i) == '}') || (exp.charAt(i) == ']')) {
                if (stack.isEmpty() || !Are_Pair(stack.peek(), exp.charAt(i)))
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        if (areParenthesisBalanced(str))
            System.out.println("Balanced\n");
        else
            System.out.println("Not Balanced\n");
    }
}
