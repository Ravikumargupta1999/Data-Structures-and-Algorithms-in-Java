import java.util.Stack;

public class S_Stack_Queue_305_The_Celebrity_Problem {
    // https://www.youtube.com/watch?v=CiiXBvrX-5A
    // https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#
    int celebrity(int[][] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int i = stack.pop();
            int j = stack.pop();
            if (arr[i][j] == 1) {
                stack.push(j);
            } else {
                stack.push(i);
            }
        }

        int pot = stack.pop();
        for (int i = 0; i < arr.length; i++) {
            if (pot != i) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    return -1;
                }
            }
        }
        return pot;
    }
}
