package Day_13_Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_II {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--)
            st.push(nums[i]);

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums[i])
                st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return res;
    }
}
