import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int val = i == heights.length ? 0 : heights[i];
            while (st.peek() != -1 && heights[st.peek()] >= val) {
                int rm = i;
                int h = heights[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea, h * (rm - lm - 1));
            }
            st.push(i);
        }
        return maxArea;

    }
}
