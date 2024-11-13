import java.util.Stack;

public class S_Stack_Queue_302_Reverse_String {
    //https://practice.geeksforgeeks.org/problems/reverse-a-string-using-stack/1
    public static String reverse(String S) {
        Stack<Character> st = new Stack<>();
        for (char ch : S.toCharArray()) {
            st.push(ch);
        }
        S = "";
        while (st.size() > 0) {
            S += "" + st.pop();
        }
        return S;
    }
}
