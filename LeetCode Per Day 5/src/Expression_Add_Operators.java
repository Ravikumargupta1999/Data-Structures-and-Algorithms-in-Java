import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// https://leetcode.com/problems/expression-add-operators/
public class Expression_Add_Operators {
    public static void main(String[] args) {
        Expression_Add_Operators obj = new Expression_Add_Operators();
        System.out.println(obj.addOperators("123",6));
    }

    public List<String> addOperators(String num, int target) {

        List<String> list = new ArrayList<>();
        solve("", num, list, target);
        return list;
    }

    public void solve(String left, String right, List<String> list, int target) {
//        System.out.println(left+"   "+right);
        if (right.length() == 0) {
//            System.out.println(left);
            evaluateExpression(left, list, target);
            return;
        }
        if (right.length() == 1) {
            solve(left + "" + right.charAt(0), "", list, target);
        } else {
            if(left.length() != 0) {
                solve(left + "" + right.charAt(0) + "+", right.substring(1), list, target);
                solve(left + "" + right.charAt(0) + "-", right.substring(1), list, target);
                solve(left + "" + right.charAt(0) + "*", right.substring(1), list, target);
            }else {
                solve( right.charAt(0) + "+", right.substring(1), list, target);
                solve( right.charAt(0) + "-", right.substring(1), list, target);
                solve(right.charAt(0) + "*", right.substring(1), list, target);
            }
        }
    }

    public void evaluateExpression(String expression, List<String> list, int target) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch))
                operands.push(ch - '0');
            else {
                while (operators.size() > 0 && preference(ch) <= preference(operators.peek())) {
                    char operator = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int val = operation(v1, v2, operator);
                    operands.push(val);
                }
                operators.push(ch);
            }
        }
        while (operators.size() > 0) {
            char operator = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            int val = operation(v1, v2, operator);
            operands.push(val);
        }
        if (operands.peek() == target)
            list.add(expression);

    }

    public int operation(int v1, int v2, char ch) {
        if (ch == '+')
            return v1 + v2;
        else if (ch == '-')
            return v1 - v2;
        return v1 * v2;
    }

    public int preference(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else
            return 2;
    }
}
