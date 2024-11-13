package Day_13_Stack;

import java.util.Stack;

public class Sort_A_Stack {
    // https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
    public static void main(String[] args) {
        int[] arr = {5, -2, 9, -7, 3};
        Stack<Integer> st = new Stack<>();
        for (int num : arr)
            st.push(num);
        System.out.println(st);
        sortStack(st);
        System.out.println(st);
    }

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (!stack.isEmpty()) {
            int num = stack.pop();

            if (s1.isEmpty()) {
                s1.push(num);
            } else {
                if (num < s1.peek()) {
                    s1.push(num);
                } else {
                    while (s1.size() > 0 && s1.peek() <= num)
                        s2.push(s1.pop());
                    s1.push(num);
                    while (!s2.isEmpty())
                        s1.push(s2.pop());
                }
            }
        }
        while (!s1.isEmpty())
            stack.push(s1.pop());
    }

}
