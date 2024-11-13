import java.util.Stack;

public class Leetcode_2390_Removing_Stars_From_a_String {
    // https://leetcode.com/contest/weekly-contest-308/problems/removing-stars-from-a-string/
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
