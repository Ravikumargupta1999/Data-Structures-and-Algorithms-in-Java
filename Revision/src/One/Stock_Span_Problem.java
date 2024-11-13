package One;

import java.sql.Array;
import java.util.Arrays;
import java.util.Stack;

public class Stock_Span_Problem {
    // Wrong Solution
//    public static int[] calculateSpan(int price[], int n) {
//        int[] arr = new int[n];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && price[stack.peek()] < price[i])
//                stack.pop();
//
//            arr[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
//            stack.push(i);
//        }
//        return arr;
//    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
//        System.out.println(Arrays.toString(calculateSpan(arr, arr.length)));
    }
}
