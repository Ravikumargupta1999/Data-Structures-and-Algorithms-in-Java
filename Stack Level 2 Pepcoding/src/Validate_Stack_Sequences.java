import java.util.Stack;

//https://leetcode.com/problems/validate-stack-sequences/submissions/
public class Validate_Stack_Sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = popped.length;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                ++i;
            }
        }
        return i == n;
    }
}
