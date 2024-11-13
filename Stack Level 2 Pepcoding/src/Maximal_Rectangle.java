import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/maximal-rectangle/submissions/
public class Maximal_Rectangle {
    public static int maximalRectangle(char[][] matrix) {
        if( matrix.length == 0 )
            return 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == '1')
                heights[i] = 1;
            else
                heights[i] = 0;
        }
        int area = largestRectangleArea(heights);

        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j] == '1')
                {
                    heights[j]++;
                }
                else
                {
                    heights[j] = 0;
                }
            }
//            System.out.println(Arrays.toString(heights));
            area = Math.max(area,largestRectangleArea(heights));
        }
        return area;

    }

    public static int largestRectangleArea(int[] heights) {
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

    public static void main(String[] args) {
        char[][] arr = {{'0','1'},{'0','1'}};
        System.out.println(maximalRectangle(arr));
    }
}
