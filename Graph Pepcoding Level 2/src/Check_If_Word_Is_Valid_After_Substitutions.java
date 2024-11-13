import java.util.Stack;
// https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
public class Check_If_Word_Is_Valid_After_Substitutions {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(ch == 'c')
            {
                if(stack.size() >= 2 && stack.pop() =='b' && stack.pop() =='a')
                {
                    // paired
                }
                else
                {
                    return false;
                }
            }
            else
            {
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }
}
