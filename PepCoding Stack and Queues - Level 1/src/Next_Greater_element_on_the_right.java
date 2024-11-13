import java.sql.Array;
import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_element_on_the_right {
    public static void main(String[] args) {
        long[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        System.out.println(Arrays.toString(nextGreaterElementOnRight(arr)));
        int[] arr1 = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        System.out.println(Arrays.toString(nextGreater(arr1)));
    }

    // https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
    public static long[] nextGreaterElementOnRight(long[] arr) {
        Stack<Long> stack = new Stack<>();
        long[] res = new long[arr.length];
        int n = arr.length;
        res[n - 1] = -1;
        stack.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (stack.size() != 0 && stack.peek() > arr[i]) {
                res[i] = stack.peek();
                stack.push(arr[i]);
            } else {
                while (stack.size() != 0 && stack.peek() <= arr[i])
                    stack.pop();
                if (stack.size() == 0)
                    res[i] = -1;
                else
                    res[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return res;
    }

    // Alternate Solution
    static int[] nextGreater(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                int pos = st.peek();
                res[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (st.size() > 0) {
            int pos = st.peek();
            res[pos] = -1;
            st.pop();
        }
        return res;
    }
}
