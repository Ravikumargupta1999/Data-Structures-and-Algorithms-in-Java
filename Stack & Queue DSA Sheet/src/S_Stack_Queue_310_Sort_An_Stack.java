import java.util.*;

public class S_Stack_Queue_310_Sort_An_Stack {
    // https://practice.geeksforgeeks.org/problems/sort-a-stack/1#
    public Stack<Integer> sort(Stack<Integer> stack1) {
//        if(stack1.size() == 0 || stack1.size() == 1)
//            return stack1;
//        Stack<Integer> stack2 = new Stack<>();
//        while (!stack1.isEmpty()){
//            int temp = stack1.pop();
//            while (!stack2.isEmpty() && stack2.peek() < temp){
//                stack1.push(stack2.pop());
//            }
//            stack2.push(temp);
//        }
//        while (!stack2.isEmpty()){
//            stack1.push(stack2.pop());
//        }
//        return stack1;


        if(stack1.size() == 0 || stack1.size() == 1)
            return stack1;
        Stack<Integer> stack2 = new Stack<>();

        while (!stack1.isEmpty()){
            int temp = stack1.pop();

            while (!stack2.isEmpty() && stack2.peek() < temp){
                stack1.push(stack2.pop());
            }
            stack2.push(temp);
        }
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return stack1;
    }
}
