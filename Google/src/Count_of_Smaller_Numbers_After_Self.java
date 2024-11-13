import java.util.*;

public class Count_of_Smaller_Numbers_After_Self {
    public List<Integer> countSmaller(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[n - 1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Stack<Integer> st = new Stack<>();
        pq.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (pq.peek() < arr[i]) {
                res[i] = pq.size();
            } else {
                Stack<Integer> stack = new Stack<>();
                while (!pq.isEmpty() && pq.peek() >= arr[i]) {
                    st.push(pq.poll());
                }
                if (pq.isEmpty())
                    res[i] = 0;
                else
                    res[i] = pq.size();
                while (!st.isEmpty()) {
                    pq.add(st.pop());
                }
            }
            pq.add(arr[i]);
        }
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++)
            al.add(res[i]);
        return al;

    }
}
