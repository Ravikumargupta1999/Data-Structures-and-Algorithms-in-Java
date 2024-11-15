package Day_14_Stack_And_Queue_Part_II;

import java.util.Stack;

public class Largest_Rectangle_In_Histogram {

    // https://leetcode.com/problems/largest-rectangle-in-histogram/

    public int largestRectangleArea(int[] heights) {
        int[] rb = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        st.push(heights.length - 1);
        rb[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            while (st.size() > 0 && heights[i] <= heights[st.peek()])
                st.pop();
            if (st.size() == 0) {
                rb[i] = heights.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        int[] lb = new int[heights.length];
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            while (st.size() > 0 && heights[i] <= heights[st.peek()])
                st.pop();
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);

        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }
        return maxArea;

    }
}
