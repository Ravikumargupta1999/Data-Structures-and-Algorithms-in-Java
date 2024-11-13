import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Video_45_Remove_Invalid_Parenthesis {
    // https://www.youtube.com/watch?v=Cbbf5qe5stw&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=17
    // https://practice.geeksforgeeks.org/problems/remove-invalid-parentheses/1#
    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        if (minRemoval == 0) {
            // now check if string doesnt need any removal then its valid i.e. now it will be added in answer
            int minRemovalNow = getMin(str);
            if (minRemovalNow == 0) {
                if (!ans.contains(str)) {
                    System.out.println(str);
                    ans.add(str);
                }
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            solution(left + right, minRemoval - 1, ans);
        }
    }

    public static int getMin(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                if (stack.size() == 0) {
                    stack.push(ch);
                } else if (stack.peek() == ')') {
                    stack.push(ch);
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str), new HashSet<>());
    }

}
