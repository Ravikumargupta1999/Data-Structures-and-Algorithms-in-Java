import java.util.Stack;

public class S_Stack_Queue_307_Postfix_Evaluation {
    // https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1/#
    public static int evaluatePostFix(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (isNumericDigit(ch)) {
                int val = Character.getNumericValue(ch);
                stack.push(val);
            } else if (isOperator(ch)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(performOperation(ch, op1, op2));
            }
        }
        return stack.peek();
    }

    static boolean isNumericDigit(char C) {
        if (C >= '0' && C <= '9') return true;
        return false;
    }

    static boolean isOperator(char C) {
        if (C == '+' || C == '-' || C == '*' || C == '/')
            return true;

        return false;
    }

    static int performOperation(char operation, int operand1, int operand2) {
        if (operation == '+')
            return operand1 + operand2;
        else if (operation == '-')
            return operand1 - operand2;
        else if (operation == '*')
            return operand1 * operand2;
        else if (operation == '/')
            return operand1 / operand2;

        else
            System.out.println("Unexceptional Error");
        return -1;
    }

}
