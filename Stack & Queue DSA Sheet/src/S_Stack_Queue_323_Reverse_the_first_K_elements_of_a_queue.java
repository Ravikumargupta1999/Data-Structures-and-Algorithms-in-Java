import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

// TLE
public class S_Stack_Queue_323_Reverse_the_first_K_elements_of_a_queue {
    // Using Both Stack && Queue
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();

        while (k-- > 0)
            st.push(q.poll());
        Queue<Integer> result = new LinkedList<>();

        while (!q.isEmpty())
            result.add(q.remove());

        // System.out.println(st);
        // System.out.println(result);
        while (!st.isEmpty())
            q.add(st.pop());

        while (!result.isEmpty())
            q.add(result.remove());
        return q;
    }

    // USing Only Stack
    public Queue<Integer> modifyQueue1(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k > queue.size())
            return queue;
        if (k <= 0)
            return queue;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.peek());
            queue.remove();
        }


        while (!stack.empty()) {
            queue.add(stack.peek());
            stack.pop();
        }
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
        return queue;
    }


}
