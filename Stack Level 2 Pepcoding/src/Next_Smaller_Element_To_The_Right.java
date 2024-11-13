import java.util.Arrays;
import java.util.Stack;

public class Next_Smaller_Element_To_The_Right {
    public static int[] solve(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.add(arr[n - 1]);
        ans[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (st.peek() < arr[i]) {
                ans[i] = st.peek();
                st.push(arr[i]);
            } else {
                while (st.size() != 0 && st.peek() > arr[i])
                    st.pop();
                if (st.size() == 0)
                    ans[i] = -1;
                else
                    ans[i] = st.peek();
                st.push(arr[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7})));
    }
}
