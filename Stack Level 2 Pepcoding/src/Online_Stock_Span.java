import java.util.ArrayList;
import java.util.Stack;

public class Online_Stock_Span {

    static Stack<Integer> st = new Stack<>();
    public static int next(int price) {
        st.push(price);
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty() && st.peek() <= price)
            temp.push(st.pop());
        int ans = temp.size();
        while (!temp.isEmpty())
            st.push(temp.pop());
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        for (int i = 0; i < arr.length; i++)
            System.out.print(next(arr[i])+"   ");
        System.out.println("");
    }
}