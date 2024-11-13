import java.util.Stack;

//https://leetcode.com/problems/validate-stack-sequences/submissions/
public class S_Stack_Queue_317_Validate_Stack_Sequence {
    public static boolean checkStackPermutation(int[] pushed, int[] popped) {
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
    public static int isStackPermutation(int N, int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = popped.length;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                ++i;
            }
        }
        return i == n ? 1 : 0;
    }
}
