import java.util.Stack;

public class S_Stack_Queue_307_Infix_To_Postfix_Coding_Ninja {

    // https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
    // https://www.codingninjas.com/codestudio/problems/infix-to-postfix_1382146?leftPanelTab=1
    // https://www.youtube.com/watch?v=vq-nUF0G4fI
    
    public static String infixToPostfix(String exp) {

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (char ch : exp.toCharArray()) {
//            System.out.println(ch+"   "+stack);
            if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
//                System.out.println(stack);
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            } else if (isOperator(ch)) {

                while (!stack.isEmpty() && stack.peek()!= '(' && orderOfPrefrence(stack.peek()) >= orderOfPrefrence(ch)){
                    sb.append(stack.peek());
                    stack.pop();
                }
                stack.push(ch);
            } else {
                sb.append(ch);
            }
//            System.out.println("\n");
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    static int orderOfPrefrence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else
            return 3;
    }

    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b+c+d-e"));
    }
}
