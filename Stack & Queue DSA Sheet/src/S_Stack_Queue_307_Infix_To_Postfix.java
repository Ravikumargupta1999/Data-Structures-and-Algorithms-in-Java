import java.util.Scanner;
import java.util.Stack;

public class S_Stack_Queue_307_Infix_To_Postfix {

    // https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1/#
    public static String infixToPostfix(String exp) {
        String res = "";
        Stack<Character> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) res += ch;
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.pop();
                }
                if (!stack.isEmpty()) stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    res += stack.pop();
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static int precedence(char ch) {
        if (ch == '^') return 3;
        else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }
        return 0;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "A*(B+C)/D";
        str = infixToPostfix(str);
        System.out.println(str);
        System.out.println("");
    }
}