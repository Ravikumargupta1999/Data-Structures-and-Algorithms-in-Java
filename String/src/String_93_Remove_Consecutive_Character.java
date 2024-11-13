import java.util.Stack;

public class String_93_Remove_Consecutive_Character {
    // https://practice.geeksforgeeks.org/problems/consecutive-elements2306/1
    // https://www.codingninjas.com/codestudio/problems/remove-consecutive-duplicates_893195?leftPanelTab=1
    public static String removeConsecutiveCharacter(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != ch)
                stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }


}
