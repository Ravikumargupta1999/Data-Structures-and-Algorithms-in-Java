import java.util.*;

// https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
// https://leetcode.com/problems/sliding-window-maximum/submissions/
// https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/#
public class S_Stack_Queue_328_Sliding_Window_Maximum {
    static ArrayList<Integer> max_of_subarrays1(int[] arr, int n, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                priorityQueue.add(arr[i]);
            } else {
                priorityQueue.add(arr[i]);
                arrayList.add(priorityQueue.peek());
                priorityQueue.remove(arr[j++]);
            }
        }
        return arrayList;
    }

    public static ArrayList<Integer> slidingWindowMaximum(int[] arr, int n, int k) {

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


        ArrayList<Integer> al = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if (j < i)
                j = i;
            while (nge[j] < i + k)
                j = nge[j];
            al.add(arr[j]);
        }
        return al;
    }



}
