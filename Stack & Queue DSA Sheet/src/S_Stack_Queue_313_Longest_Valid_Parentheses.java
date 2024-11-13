import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
// https://practice.geeksforgeeks.org/problems/longest-valid-parentheses5657/1
// https://practice.geeksforgeeks.org/problems/valid-substring0624/1/?category[]=Stack&category[]=Stack&difficulty[]=0&page=2&query=category[]Stackdifficulty[]0page2category[]Stack
// https://www.youtube.com/watch?v=8CYhffMML8o
public class S_Stack_Queue_313_Longest_Valid_Parentheses {
    static int maxLength(String s) {
        int length = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    length = Math.max(length, i - stack.peek());
                }
            }
        }
        return length;
    }

}
