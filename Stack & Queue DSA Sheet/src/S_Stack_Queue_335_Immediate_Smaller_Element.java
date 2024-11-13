import java.util.Stack;
// https://practice.geeksforgeeks.org/problems/immediate-smaller-element1142/1/?category[]=Stack&category[]=Stack&page=2&query=category[]Stackpage2category[]Stack#

public class S_Stack_Queue_335_Immediate_Smaller_Element {
    static void immediateSmaller(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);
        arr[n-1] = -1;
        for(int i = n - 2;i >=0 ;i--)
        {
            int temp = arr[i];
            if(stack.peek()<arr[i])
                arr[i] = stack.peek();
            else
                arr[i] = -1;
            stack.push(temp);
        }
    }
}
