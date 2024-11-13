import java.util.*;
// https://practice.geeksforgeeks.org/problems/remove-invalid-parentheses/1#
public class Video_45_Remove_Invalid_Parentheses_GFG {
    static ArrayList<String> result = new ArrayList<>();
    static Set<String> set1 = new HashSet<>();

    public static ArrayList<String> removeInvalidParentheses(String s) {
        if (s.equals("()")) {
            ArrayList<String> l = new ArrayList<>();
            l.add(s);
            return l;
        }

        int minRemovals = getMinRemoval(s);
        Set<String> set = new HashSet<>();
        removeInvalidParenthesesRecursion(s, minRemovals, set);
        Collections.sort(result);
        return result;

    }

    static void removeInvalidParenthesesRecursion(String s, int min, Set<String> set) {

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

            if (!set1.contains(left + right)) {

                set1.add(left + right);
                removeInvalidParenthesesRecursion(left + right, min - 1, set);
            }

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

    public static void main(String[] args) {
        String s = "()";
        ArrayList<String> list = removeInvalidParentheses(s);
        for (String s1 : list)
            System.out.println(s1 + "  " + s1.length());
    }
}
