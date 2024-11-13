import java.util.Stack;

// Sumeet Malik
public class S_Stack_Queue_304_Next_Greater_Element {
    // https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1#
    // https://www.youtube.com/watch?v=rSf9vPtKcmI
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] res = new long[n];
        res[n - 1] = -1;
        Stack<Long> st = new Stack<>();
        st.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() < arr[i])
                st.pop();
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    //    https://practice.geeksforgeeks.org/problems/greater-on-right-side4305/1

    void nextGreatest(int arr[], int n) {
        int prev = arr[n - 1];
        arr[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {

            int curr = arr[i];

            arr[i] = prev;

            prev = Math.max(curr, prev);
        }

    }
}

