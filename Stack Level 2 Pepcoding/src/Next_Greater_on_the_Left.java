import java.util.Stack;

public class Next_Greater_on_the_Left {
    public static int[] solve(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[0] = -1;
        Stack<Integer> st = new Stack<>();
        st.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (st.size() != 0 && st.peek() > arr[i]) {
                ans[i] = st.peek();
                st.push(arr[i]);
            } else {
                while (st.size() != 0 && st.peek() <= arr[i])
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
}
