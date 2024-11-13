public class First_Letter_to_Appear_Twice {
    // https://leetcode.com/problems/first-letter-to-appear-twice/submissions/
    public char repeatedCharacter(String s) {
        int[] frq1 = new int[26];
        for (char ch : s.toCharArray()) {
            frq1[ch - 'a']++;
            if(frq1[ch-'a'] == 2)
                return ch;
        }
        return ' ';

    }
}
