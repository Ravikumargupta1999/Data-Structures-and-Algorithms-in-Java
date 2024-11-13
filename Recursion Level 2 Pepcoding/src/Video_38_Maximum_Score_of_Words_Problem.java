import java.util.Scanner;

public class Video_38_Maximum_Score_of_Words_Problem {
    // https://leetcode.com/problems/maximum-score-words-formed-by-letters/submissions/
    // https://www.youtube.com/watch?v=XtmW3a8Q9M4&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=3
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        return solution(words, farr, score, 0);
    }

    public int solution(String[] words, int[] farr, int[] score, int idx) {
        if (idx == words.length)
            return 0;
        int sno = solution(words, farr, score, idx + 1);// words not included
        int sword = 0;
        String word = words[idx];
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (farr[ch - 'a'] == 0)
                flag = false;
            farr[ch - 'a']--;
            sword += score[ch - 'a'];
        }
        int syes = 0;
        if (flag)
            syes = sword + solution(words, farr, score, idx + 1);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }
        return Math.max(sno, syes);
    }
}
