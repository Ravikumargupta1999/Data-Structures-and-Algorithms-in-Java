import java.util.*;
// https://practice.geeksforgeeks.org/problems/remove-invalid-parentheses/1#
public class Video_45_Remove_Invalid_Parentheses_Same_Code_Optimized {
    public static ArrayList<String> removeInvalidParentheses(String s) {
        ArrayList<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int minRemovals = getMinRemoval(s);
        removeInvalidParenthesesRecursion(s, minRemovals, result, set);
        Collections.sort(result);
        return result;

    }

    static void removeInvalidParenthesesRecursion(String s, int min, ArrayList<String> result, Set<String> set) {
        if(set.contains(s))
            return;
        set.add(s);
        if (min == 0) {
            int minRemovalAllowed = getMinRemoval(s);
            if (minRemovalAllowed == 0)
                result.add(s);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            removeInvalidParenthesesRecursion(left + right, min - 1, result, set);
        }
    }

    static int getMinRemoval(String str) {
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
