import java.util.Scanner;
import java.util.Stack;

public class S_Stack_Queue_307_Prefix_Evaluation {
    // https://www.youtube.com/watch?v=MeRb_1bddWg&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=20
    static boolean IsNumericDigit(char C) {
        if (C >= '0' && C <= '9') return true;
        return false;
    }

    static boolean IsOperator(char C) {
        if (C == '+' || C == '-' || C == '*' || C == '/')
            return true;

        return false;
    }

    static int PerformOperation(char operation, int operand1, int operand2) {
        if (operation == '+') return operand1 + operand2;
        else if (operation == '-') return operand1 - operand2;
        else if (operation == '*') return operand1 * operand2;
        else if (operation == '/') return operand1 / operand2;

        else
            System.out.println("Unexceptional Error");
        return -1;
    }

    public static int postfixEvaluation(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            if (IsOperator(exp.charAt(i))) {
                int op1 = stack.peek();
                stack.pop();
                int op2 = stack.peek();
                stack.pop();
                int result = PerformOperation(exp.charAt(i), op1, op2);

                stack.push(result);
            } else if (IsNumericDigit(exp.charAt(i))) {
                char c = exp.charAt(i);
                String s = String.valueOf(c);
                int j = Integer.parseInt(s);
                stack.push(j);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int value = postfixEvaluation(str);
        System.out.println(value);
    }
}
