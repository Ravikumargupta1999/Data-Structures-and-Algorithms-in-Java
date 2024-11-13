package Day_14_Stack_And_Queue_Part_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Nearest_Smaller_Element {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        list.add(-1);
        stack.push(A.get(0));

        for (int i = 1; i < A.size(); i++) {
            int num = A.get(i);
            while (stack.size() > 0 && stack.peek() >= num)
                stack.pop();
            int ans = stack.isEmpty() ? -1 : stack.peek();
            stack.add(num);
            list.add(ans);
        }
        // Collections.reverse(list);
        return list;
    }
}
