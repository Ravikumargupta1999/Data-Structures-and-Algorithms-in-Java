import java.util.ArrayDeque;
import java.util.Deque;

public class S_Stack_Queue_316_Stack_Using_Deque_Coding_Ninja {
    class Stack {
        // Initialize your data structure.
        Deque<Integer> st ;
        Stack() {
            st = new ArrayDeque<>();
        }

        // Pushes 'X' into the stack. Returns true if it gets pushed into the stack, and false otherwise.
        public boolean push(int x) {
            st.addFirst(x);
            return true;
        }

        public int pop() {
            return st.size() > 0 ? st.removeFirst() : -1 ;
        }

        // Returns the topmost element of the stack. In case the stack is empty, it returns -1.
        public int top() {
            return st.size() > 0 ? st.getFirst() : -1;
        }

        // Returns true if the stack is empty, otherwise false.
        public boolean isEmpty() {
            return st.isEmpty();
        }

        // Returns the number of elements currently present in the stack.
        public int size() {
            return st.size();
        }
    }
}
