import java.util.Stack;

public class S_Stack_Queue_314_Redundant_Brackets {
    // https://practice.geeksforgeeks.org/problems/e015cb4d3f354b035d9665e7c8a54a7aefb1901b/1/
    // https://www.codingninjas.com/codestudio/problems/redundant-brackets_975473?leftPanelTab=1
    public static int checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.peek() == '(')
                    return 1;
                else
                    while (!st.isEmpty() && st.peek() != '(')
                        st.pop();
                if (!st.isEmpty())
                    st.pop();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "(a+c*b)+(c))";
        System.out.println(checkRedundancy(str));
    }
}
