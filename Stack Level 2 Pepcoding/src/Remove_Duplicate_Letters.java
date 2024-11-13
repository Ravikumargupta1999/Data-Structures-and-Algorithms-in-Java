import java.util.Stack;
//https://leetcode.com/problems/remove-duplicate-letters/
public class Remove_Duplicate_Letters {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] exist = new boolean[26];
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            freq[ch-'a']--;
            if(exist[ch-'a'])
                continue;
            while (st.size()>0 && st.peek() > ch && freq[st.peek()-'a']>0)
            {
                exist[st.pop()-'a'] = false;
            }
            st.push(ch);
            exist[ch-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0)
            sb.insert(0,st.pop());
        return sb.toString();
    }
}
