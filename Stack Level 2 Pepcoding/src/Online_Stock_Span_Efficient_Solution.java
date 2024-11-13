import java.util.Stack;

public class Online_Stock_Span_Efficient_Solution {
}
class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek()[0] <= price)
            span += st.pop()[1];
        st.add(new int[]{price,span});
        return span;
    }
}