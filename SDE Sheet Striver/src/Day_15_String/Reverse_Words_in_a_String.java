package Day_15_String;

import java.util.Stack;

public class Reverse_Words_in_a_String {

    //
    public String reverseWords(String s) {
        String res = "";
        StringBuilder temp = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (temp.length() > 0) {
                    res = res + temp.reverse() + " ";
                }
                temp = new StringBuilder("");
            } else {
                temp.append(ch);
            }
        }
        if (temp.length() > 0) {
            res = res + temp.reverse() + " ";
        }
        return res.substring(0, res.length() - 1);
    }

    public String reverseWords1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isAlphabetic(ch)){
                stack.push(ch);
                continue;
            }
            if (ch == ' ' && stack.size() == 0)
                continue;
            else if (ch == ' ' && stack.peek() == ' ') {
                continue;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        String res = "";
        while (!stack.isEmpty()) {
            if (stack.peek() == ' ') {
                stack.pop();
                sb = sb.reverse();
                if( sb.length() > 0)
                    res = res + sb + " ";
                sb = new StringBuilder("");
            } else {
                sb.append(stack.pop());
            }
        }
        if (sb.length() > 0) {
            res = res + sb.reverse() + " ";
        }
        return res.substring(0,res.length()-1);
    }
}
