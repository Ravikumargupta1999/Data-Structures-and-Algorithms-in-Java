import java.util.Stack;
// https://www.youtube.com/watch?v=Trz7JM610Uc
// https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1/#
public class S_Stack_Queue_303_Get_Minimum_element_from_stack_Constant_Extra_Space {
    Stack<Integer> st = new Stack<>();
    static int min;

    int getMin() {
        return st.isEmpty() ? -1 : min;
    }

    public void push(int x) {
        if (st.isEmpty()) {
            st.push(x);
            min = x;
        } else if (x >= min)
            st.push(x);
        else {
            st.push(x + x - min);
            min = x;
        }
    }

    public int pop() {
        if (st.isEmpty())
            return -1;
        else if (st.peek() >= min)
            return st.pop();
        else {
            int ov = min;
            min = 2 * min - st.pop();
            return ov;
        }
    }


}
