import java.util.Queue;
import java.util.Stack;

public class S_Stack_Queue_324_Interleave_the_first_half_of_the_queue_with_second_half {
    // https://www.codingninjas.com/codestudio/problems/interleave-the-first-half-of-the-queue-with-the-second-half_1169450?leftPanelTab=1

    public static void interLeaveQueue(Queue < Integer > q) {
        Stack<Integer> st = new Stack<>();
        int size = q.size() / 2;
        for (int i = 0; i < size; i++)
            st.add(q.poll());


        while (!st.isEmpty())
            q.add(st.pop());


        for (int i = 0; i < size; i++)
            q.add(q.poll());

        for (int i = 0; i < size; i++)
            st.add(q.poll());

        while (!st.isEmpty()) {
            q.add(st.pop());
            q.add(q.poll());
        }
    }

}
