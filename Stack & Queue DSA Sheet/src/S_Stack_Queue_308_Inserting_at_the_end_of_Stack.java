import java.util.Stack;
// https://stackoverflow.com/questions/45130465/inserting-at-the-end-of-stack
public class S_Stack_Queue_308_Inserting_at_the_end_of_Stack {
    static Stack<Integer> stack;

    static void insert_at_bottom(int x) {
        if (stack.size() == 0) {
            stack.push(x);
            return;
        }
        int val = stack.pop();
        insert_at_bottom(x);
        stack.push(val);
    }
    public static void  printStack(){
       System.out.println(stack);

    }
    public static void main(String[] args) {
        stack = new Stack<>();
        stack.push(12);
        stack.push(67);
        stack.push(56);
        printStack();
        insert_at_bottom(45);
        printStack();

    }
}
