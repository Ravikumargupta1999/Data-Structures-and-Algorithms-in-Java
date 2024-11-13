import java.util.Stack;

public class Backtracking_278_3_Parenthesis_Checker {
    // https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/0/?company[]=Flipkart&page=1&query=company[]Flipkartpage1#
    static boolean isValid(String string)
    {
        Stack<Character> st = new Stack<>();
        for(char ch : string.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (st.isEmpty())
                    return false;
                if(ch == ')' &&  st.peek() != '('){
                    return false;
                }
                else if( ch == '}' && st.peek() != '{')
                    return false;
                else if(ch == ']' && st.peek() != '[')
                    return false;
                st.pop();
            }
        }
        return st.isEmpty() ? true : false;
    }
}
