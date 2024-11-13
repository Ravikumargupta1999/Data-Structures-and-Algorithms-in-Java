import java.util.ArrayList;
import java.util.Stack;

public class S_Stack_Queue_309_Reverse_Stack_Using_Recursion {
    public static void insert(Stack<Integer> st, int ele) {
        if (st.isEmpty()) {
            st.push(ele);
            return;

        } else {
            int temp = st.pop();
            insert(st, ele);
            st.push(temp);
        }
    }

    public static void reverse1(Stack<Integer> st) {
        if (st.size() == 1)
            return;
        int temp = st.pop();
        reverse1(st);
        insert(st, temp);

    }

    // https://practice.geeksforgeeks.org/problems/reverse-a-stack/1/#
    static ArrayList<Integer> reverse(Stack<Integer> s)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!s.isEmpty())
            arrayList.add(s.pop());
        return arrayList;
    }
}
