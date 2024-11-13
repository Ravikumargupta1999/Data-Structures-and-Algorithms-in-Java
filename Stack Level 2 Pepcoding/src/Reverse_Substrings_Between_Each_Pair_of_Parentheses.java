import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/submissions/
public class Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
//        System.out.println(s.length());
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
//            System.out.println(ch+"   "+st);
            if (s.charAt(i) == '(') {
                st.push(ch);
            } else if (ch >= 97 && ch <= 122) {
                st.push(ch);
            } else {
                Queue<Character> temp = new LinkedList<>();
                while (st.peek() != '(')
                    temp.add(st.pop());
                st.pop();
                while (!temp.isEmpty())
                    st.push(temp.poll());
//                System.out.println(st);
//                System.out.println(st);
            }

        }
        while (!st.isEmpty())
            sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el(pri))"));
    }
}
