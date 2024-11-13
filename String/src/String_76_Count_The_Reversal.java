import java.util.Stack;

public class String_76_Count_The_Reversal {
    // https://www.youtube.com/watch?v=-n_CsIL3Ts4
    // https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1
    public static int CountReversal(String str) {
        if (str.length() % 2 != 0)
            return -1;
        Stack<Character> stack = new Stack<>();
        int closing = 0;
        int opening = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{') {
                stack.push(ch);
                opening++;
            } else if (ch == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
                opening--;
            } else
                closing++;
        }
        if (closing % 2 != 0)
            closing = closing / 2 + 1;
        else
            closing = closing / 2;
        if (opening % 2 != 0)
            opening = opening / 2 + 1;
        else
            opening = opening / 2;

        return closing + opening;
    }
}
