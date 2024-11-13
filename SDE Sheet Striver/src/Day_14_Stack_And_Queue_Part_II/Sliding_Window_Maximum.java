package Day_14_Stack_And_Queue_Part_II;

import java.util.*;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] arr = {1, -1};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 1)));
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()])
                st.pop();
            if (st.size() == 0)
                nge[i] = arr.length;
            else
                nge[i] = st.peek();
            st.push(i);
        }

        int j = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            if (j < i)
                j = i;
            while (nge[j] < i + k)
                j = nge[j];
            al.add(arr[j]);
        }
        int[] result = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
            result[i] = al.get(i);
        return result;
    }
}
