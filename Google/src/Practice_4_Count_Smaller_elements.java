import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice_4_Count_Smaller_elements {
    static int[] constructLowerArray(int[] arr, int n) {
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
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        arr = constructLowerArray(arr, arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("");
    }
}
