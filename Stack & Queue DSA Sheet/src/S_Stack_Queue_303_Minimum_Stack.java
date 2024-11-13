import java.util.Stack;

// https://leetcode.com/problems/min-stack/
// https://www.youtube.com/watch?v=Trz7JM610Uc&t=1248s
public class S_Stack_Queue_303_Minimum_Stack {


    class MinStack {
        // took long to avoid overflow
        Stack<Long> st;
        long min;

        public MinStack() {
            st = new Stack<>();
            min = -1;
        }

        public void push(int val) {
            if (st.size() == 0) {
                min = val;
                st.push((long) val);
            } else if (val >= min) {
                st.push((long) val);
            } else {
                st.push((long) val + val - min);
                min = val;
            }
        }

        public void pop() {
            if (st.size() == 0)
                return;
            else if (st.peek() >= min)
                st.pop();
            else {
                long ov = min;
                min = 2 * min - st.pop();
            }
        }

        public int top() {
            if (st.size() == 0)
                return -1;
            else if (st.peek() >= min) {
                long val = st.peek();
                return (int) (val);
            } else
                return (int) min;
        }

        public int getMin() {
            return (int) min;
        }
    }
}