package Day_14_Stack_And_Queue_Part_II;

import java.util.Stack;

public class The_Celebrity_Problem {
    // https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
    int celebrity(int M[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if(M[i][j] == 1)
                    break;
                if(j == M[0].length-1)
                    return i;
            }
        }
        return -1;
    }
    int celebrity1(int arr[][], int n)
    {
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
