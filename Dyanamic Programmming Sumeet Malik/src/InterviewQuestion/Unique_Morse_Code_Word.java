package InterviewQuestion;

import java.util.HashSet;

public class Unique_Morse_Code_Word {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        String[] arr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (String word : words) {
            String sb = new String("");
            for (char ch : word.toCharArray()) {

                sb = sb + arr[ch - 'a'];
            }
            set.add(sb);
        }
        return set.size();
    }
}
