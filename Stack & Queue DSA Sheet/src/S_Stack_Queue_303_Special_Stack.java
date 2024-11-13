import java.util.*;

public class S_Stack_Queue_303_Special_Stack {
    // https://practice.geeksforgeeks.org/problems/special-stack/1#
    public static void push(int a, Stack<Integer> s) {
        s.push(a);
    }

    public static int pop(Stack<Integer> s) {
        return s.pop();
    }

    public static int min(Stack<Integer> st) {
        Stack<Integer> st1 = new Stack<>();
        while (!st.isEmpty())
            st1.push(st.pop());
        int minV = Integer.MAX_VALUE;
        while (!st1.isEmpty()) {
            int temp = st1.pop();
            st.push(temp);
            if (temp < minV)
                minV = temp;
        }
        return minV;

    }

    public static boolean isFull(Stack<Integer> s, int n) {
        return (s.size() == n);
    }

    public boolean isEmpty(Stack<Integer> s) {
        return s.empty();
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int value = min(st);
        System.out.println();

    }
}
