import java.util.Arrays;
import java.util.Stack;

public class Stock_Span {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        System.out.println(Arrays.toString(stockSpan(arr1)));
    }
    //https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
    //https://www.youtube.com/watch?v=0BsPlzqksZQ&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=10
    public static int[] stockSpan(int[] arr) {
        int[] span = new int[arr.length];
        span[0] = 1;

        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()])
                st.pop();
            if (st.size() == 0)
                span[i] = i + 1;
            else
                span[i] = i - st.peek();
            st.push(i);
        }
        return span;
    }
}
