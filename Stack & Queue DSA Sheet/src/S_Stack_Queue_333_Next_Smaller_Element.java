import java.util.Stack;

public class S_Stack_Queue_333_Next_Smaller_Element {
    // https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1/
    public static int[] help_classmate(int[] arr, int n) {

        Stack<Integer> stack = new Stack<>();

        int[] nse = new int[n];
        nse[n - 1] = -1;

        stack.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= arr[i])
                stack.pop();
            if (stack.isEmpty())
                nse[i] = -1;
            else
                nse[i] = stack.peek();
            stack.push(arr[i]);
        }
        return nse;
    }
}
