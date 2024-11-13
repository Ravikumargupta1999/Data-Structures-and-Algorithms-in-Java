import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/
    // https://www.interviewbit.com/problems/evaluate-expression/
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                perform(str,stack);
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
    public void perform(String str,Stack<Integer> stack){
        int b = stack.pop();
        int a=stack.pop();
        if(str.equals("+"))
            stack.push(a + b);
        else if(str.equals("-"))
            stack.push(a-b);
        else if(str.equals("*"))
            stack.push(a*b);
        else
            stack.push(a/b);
    }
}
