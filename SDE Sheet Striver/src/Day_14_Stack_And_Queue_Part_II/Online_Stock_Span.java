package Day_14_Stack_And_Queue_Part_II;

import java.util.Stack;
// https://leetcode.com/problems/online-stock-span/submissions/
public class Online_Stock_Span {
    class StockSpanner {
        Stack<int[]> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price)
                span += stack.pop()[1];
            stack.add(new int[]{price,span});
            return span;
        }
    }
}
