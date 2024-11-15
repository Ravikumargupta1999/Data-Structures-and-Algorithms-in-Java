import java.util.*;
import java.util.HashSet;
import java.util.List;

public class Backtracking_278_2_Remove_Invalid_Parentheses {
    List<String> result = new ArrayList<>();
    Set<String> allReadyProcessed = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int minRemovals = getMinRemoval(s);

        Set<String> set = new HashSet<>();
        removeInvalidParenthesesRecursion(s, minRemovals, set);
        return result;

    }

    private void removeInvalidParenthesesRecursion(String s, int min, Set<String> set) {

        if (min == 0) {

            int minRemovalAllowed = getMinRemoval(s);
            if (minRemovalAllowed == 0) {
                if (!set.contains(s)) {
                    set.add(s);
                    result.add(s);
                }
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);

            if (!allReadyProcessed.contains(left + right)) {

                allReadyProcessed.add(left + right);
                removeInvalidParenthesesRecursion(left + right, min - 1, set);
            }

        }
    }

    private int getMinRemoval(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '(') {
                stack.push(currentChar);
            }
            if (currentChar == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }
        }
        return stack.size();
    }
}
