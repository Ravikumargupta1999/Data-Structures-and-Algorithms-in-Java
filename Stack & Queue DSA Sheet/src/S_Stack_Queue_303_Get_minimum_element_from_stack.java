import java.util.Stack;

public class S_Stack_Queue_303_Get_minimum_element_from_stack {
    // https://www.youtube.com/watch?v=4bjCEJmiPZA
    // TC
    // getMin() : O(1)
    // pop() : O(1)
    // push() : O(1)
    // But we are maintaining extra stack which is not allowed
    Stack<Integer> allData = new Stack<>();
    Stack<Integer> minData = new Stack<>();
    int size = 0;

    int getMin() {
        return size == 0 ? -1 : minData.peek();
    }

    int pop() {
        if (size == 0)
            return -1;
        int val = allData.pop();
        if (minData.peek() == val)
            minData.pop();
        size--;
        return val;
    }

    void push(int x) {
        if (minData.size() == 0 || minData.peek() >= x) {
            minData.push(x);
            allData.push(x);
        } else {
            allData.push(x);
        }
        size++;
    }

}
