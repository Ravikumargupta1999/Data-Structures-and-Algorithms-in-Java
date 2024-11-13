import java.util.Arrays;
import java.util.Stack;

public class S_Stack_Queue_312_Largest_Area_Histogram {
    // https://www.youtube.com/watch?v=0do2734xhnU
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    public static int largestRectangleArea(int[] hist) {
        int n = hist.length;
        int[] rb = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(hist.length - 1);
        rb[hist.length - 1] = hist.length;
        for (int i = hist.length - 2; i >= 0; i--) {
            while (st.size() > 0 && hist[i] <= hist[st.peek()])
                st.pop();
            if (st.size() == 0) {
                rb[i] = hist.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(rb));
        int[] lb = new int[n];
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < hist.length; i++) {
            while (st.size() > 0 && hist[i] <= hist[st.peek()])
                st.pop();
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);

        }

        int maxArea = 0;
        for (int i = 0; i < hist.length; i++) {
            int width = rb[i] - lb[i] - 1;
            maxArea = Math.max(maxArea, width * hist[i]);
        }
        return maxArea;
    }

    // https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1#
    public static long getMaxArea(long[] heights, long n) {
        long[] rb = new long[heights.length];
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

        long maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            long width = rb[i] - lb[i] - 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }
        return maxArea;
    }
    public static long LargestAreaHistogram(long[] arr, long n) {
        n = arr.length;
        long[] lb = new long[(int) n]; //next smaller element on left2
        long[] rb = new long[(int) n]; //next smaller element on right

        //calculate rb using stack
        Stack<Integer> s = new Stack<>();
        rb[(int) n - 1] = n;
        s.push((int) n - 1);

        for (long i = n - 2; i >= 0; i--) {
            while (!s.isEmpty() && arr[(int) i] <= arr[s.peek()])
                s.pop();

            if (s.isEmpty()) {
                s.push((int) i);
                rb[(int) i] = n;
            } else {
                rb[(int) i] = s.peek();
                s.push((int) i);
            }
        }

        //Calculate lb using stack
        s = new Stack<>();
        lb[0] = -1;
        s.push(0);

        for (long i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[(int) i] <= arr[s.peek()])
                s.pop();

            if (s.isEmpty()) {
                s.push((int) i);
                lb[(int) i] = -1;
            } else {
                lb[(int) i] = s.peek();
                s.push((int) i);
            }
        }

        //Calculate maxArea using lb and rb
        long maxArea = 0;
        for (long i = 0; i < n; i++) {
            long width = rb[(int) i] - lb[(int) i] - 1;
            long area = width * arr[(int) i];

            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
    public static long LargestAreaHistogram1(long[] arr, long n) {
        Stack<Integer> s = new Stack<>();
        long max_area = 0;
        long tp;
        long area_with_top;
        long i = 0;
        while (i < n)
        {
            if (s.empty() || arr[s.peek()] <= arr[(int)i])
                s.push((int)i++);
            else
            {
                tp = s.peek();
                s.pop();
                area_with_top = arr[(int)tp] * (s.empty() ? i : i - s.peek() - 1);
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }
        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = arr[(int)tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }
        return max_area;
    }
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangleArea(arr));
    }
}
