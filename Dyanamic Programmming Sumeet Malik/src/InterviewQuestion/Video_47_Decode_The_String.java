package InterviewQuestion;

import java.util.Stack;

public class Video_47_Decode_The_String {
    // https://practice.geeksforgeeks.org/problems/decode-the-string2444/1
    static String decodedString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(s.charAt(i)))
                    num = num * 10 + Character.getNumericValue(s.charAt(i++));
                stack.push(num + "");
                stack.push(s.charAt(i) + "");
            } else if (ch == '[' || Character.isLowerCase(ch) || Character.isUpperCase(ch)) {
                stack.push(ch + "");
            } else {

                String sb = new String("");
                while (!stack.peek().equals("["))
                    sb = stack.pop() + sb;
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                String temp = new String("");
                while (num-- > 0)
                    temp += sb;
                stack.push(temp);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(decodedString("11[geeks]"));
    }
}
