import java.util.Stack;
// https://www.geeksforgeeks.org/arithmetic-expression-evalution/#:~:text=The%20stack%20organization%20is%20very,i.e.%2C%20A%20%2B%20B).
public class S_Stack_Queue_306_Infix_Evaluation_For_0_to_9_Digit {
    // https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/infix-evaluation-official/ojquestion
    // https://www.youtube.com/watch?v=IY0nZLEg6MA&t=342s

    // Valid for only 0 to 9 digit
    public static int precedence(char c) {
        if (c == '+')
            return 1;
        else if (c == '-')
            return 1;
        else if (c == '*')
            return 2;
        else
            return 2;
    }

    public static int operation(int v1, int v2, char c) {
        if (c == '+')
            return v1 + v2;
        else if (c == '-')
            return v1 - v2;
        else if (c == '*')
            return v1 * v2;
        else
            return v1 / v2;
    }

    public static int evaluateArithmeticExpression(String str){
    Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(')
                operatorsStack.push(ch);
            else if (Character.isDigit(ch))
                operandStack.push(ch - '0');
            else if (ch == ')') {
                while (operatorsStack.peek() != '(') {
                    char operator = operatorsStack.pop();
                    int v2 = operandStack.pop();
                    int v1 = operandStack.pop();
                    int v = operation(v1, v2, operator);
                    operandStack.push(v);
                }
                operatorsStack.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operatorsStack.size() > 0 && operatorsStack.peek() != '(' && precedence(ch) <= precedence(operatorsStack.peek())) {
                    char operator = operatorsStack.pop();
                    int v2 = operandStack.pop();
                    int v1 = operandStack.pop();
                    int v = operation(v1, v2, operator);
                    operandStack.push(v);
                }
                operatorsStack.push(ch);
            }
        }
        while (operatorsStack.size() != 0) {
            char operator = operatorsStack.pop();
            int v2 = operandStack.pop();
            int v1 = operandStack.pop();
            int v = operation(v1, v2, operator);
            operandStack.push(v);

        }
        return operandStack.peek();
    }

    public static void main(String[] args) {
        String str = "(121+(101+0))";
        System.out.println(evaluateArithmeticExpression(str));
    }

}
