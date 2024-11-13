public class Leetcode_50_Length_of_Last_word {
    // https://leetcode.com/problems/length-of-last-word/submissions/
    //
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (len > 0)
                    return len;
                continue;
            }
            len++;
        }
        return len;
    }
}
