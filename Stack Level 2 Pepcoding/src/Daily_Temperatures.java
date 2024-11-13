import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek()[0] <= temperatures[i]) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = 0;
            else
                ans[i] = st.peek()[1] - i;
            st.add(new int[]{temperatures[i], i});
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        System.out.println(Arrays.toString(dailyTemperatures(arr)));

    }
}
