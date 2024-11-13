import java.util.Stack;

// Done

public class Matrix_49_Largest_Area_Histogram {
    // TC : O(n^2)
    // SC : O(1)
    public static long getMaxArea1(long[] hist, long n) {
        long max = 0;
        for (long i = 0; i < n; i++) {
            long left = findLeftMax(i, hist);
            long right = findRightMax(i, hist);
            max = Math.max(max, (right - left - 1) * (hist[(int) i]));

        }
        return max;
    }

    public static long findLeftMax(long index, long[] hist) {
        long leftIndex = index - 1;
        while (leftIndex >= 0) {
            if (hist[(int) leftIndex] < hist[(int) index])
                return leftIndex;
            leftIndex--;
        }
        return leftIndex;
    }

    public static long findRightMax(long index, long[] hist) {
        long rightIndex = index + 1;
        while (rightIndex < hist.length) {
            if (hist[(int) rightIndex] < hist[(int) index])
                return rightIndex;
            rightIndex++;
        }
        return rightIndex;
    }
    // https://www.youtube.com/watch?v=0do2734xhnU
    // Method 2
    // TC : O(n)
    // SC : O(n)
    public static long getMaxArea2(long[] hist, long n) {
        long[] rightSmaller = nextSmallerElementOnRight(hist);
        long[] leftSmaller = nextSmallerElementOnLeft(hist);
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (rightSmaller[(int) i] - leftSmaller[(int) i] - 1)*(hist[i]));
        }
        return max;
    }

    public static long[] nextSmallerElementOnRight(long[] hist) {
        long[] res = new long[hist.length];
        res[hist.length - 1] = hist.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(hist.length - 1);
        for (int i = hist.length - 2; i >= 0; i--) {
            while (stack.size() != 0 && hist[i] <= hist[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.size() > 0 ? stack.peek() : hist.length;
            stack.push(i);
        }
        return res;
    }

    public static long[] nextSmallerElementOnLeft(long[] hist) {
        long[] res = new long[hist.length];
        res[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < hist.length; i++) {
            while (stack.size() != 0 && hist[i] <= hist[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = {7, 2, 8, 9, 1, 3,6 ,5};
        System.out.println(getMaxArea2(arr,arr.length));
    }
}
