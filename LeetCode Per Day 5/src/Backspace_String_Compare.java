import java.util.Stack;

public class Backspace_String_Compare {
    // https://leetcode.com/problems/backspace-string-compare/submissions/838729723/
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        for (char ch : s.toCharArray()){
            if(ch == '#'){
                if(!s1.isEmpty())
                    s1.pop();
            }else {
                s1.push(ch);
            }
        }
        String temp1 = "";
        while (!s1.isEmpty())
            temp1 += s1.pop();

        Stack<Character> s2 = new Stack<>();
        for (char ch : t.toCharArray()){
            if(ch == '#'){
                if(!s2.isEmpty())
                    s2.pop();
            }else {
                s2.push(ch);
            }
        }
        String temp2 = "";
        while (!s2.isEmpty())
            temp2 += s2.pop();
        return temp1.equals(temp2);
    }
}
