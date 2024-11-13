package Microsoft;

import java.util.HashSet;
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/868417085/
    public int evalRPN(String[] tokens) {
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("*");
        set.add("-");
        set.add("/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!set.contains(token)) {
                stack.add(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                if (token.equals("+"))
                    stack.push(a + b);
                else if (token.equals("-"))
                    stack.push(a - b);
                else if (token.equals("*"))
                    stack.push(a * b);
                else
                    stack.push(a / b);
            }
        }
        return stack.peek();
    }
}
