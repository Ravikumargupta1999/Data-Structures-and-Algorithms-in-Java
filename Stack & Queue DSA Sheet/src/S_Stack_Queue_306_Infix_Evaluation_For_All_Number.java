import java.util.Stack;
// https://www.codingninjas.com/codestudio/problems/arithmetic-expression-evaluation_1170517?leftPanelTab=1

public class S_Stack_Queue_306_Infix_Evaluation_For_All_Number {
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
//        System.out.println(v1 +"  "+v2+"    "+c);
        if (c == '+')
            return v1 + v2;
        else if (c == '-')
            return v1 - v2;
        else if (c == '*')
            return v1 * v2;
        else
            return v1 / v2;
    }

    public static int evaluateArithmeticExpression(String str) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '(')
                operatorsStack.push(ch);

            else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(str.charAt(i));
                    i++;
                }
                i--;
                operandStack.push(num);
            }

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
        String str = "(3*(5+2)*(10-7))";
        System.out.println(evaluateArithmeticExpression(str));
    }

}
