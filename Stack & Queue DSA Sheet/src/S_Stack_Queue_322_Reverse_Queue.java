import java.util.Queue;
import java.util.Stack;

public class S_Stack_Queue_322_Reverse_Queue {

    // https://practice.geeksforgeeks.org/problems/queue-reversal/1
    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty())
            stack.push(q.poll());
        while (!stack.isEmpty())
            q.add(stack.pop());
        return q;
    }

    // Using Recursion
    public Queue<Integer> reverse(Queue<Integer> q) {
        if (q.size() == 0)
            return q;
        int temp = q.poll();
        reverse(q);
        q.add(temp);
        return q;

    }
}
