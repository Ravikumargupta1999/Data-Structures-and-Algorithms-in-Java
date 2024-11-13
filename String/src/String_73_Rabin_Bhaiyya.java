import java.util.ArrayList;

public class String_73_Rabin_Bhaiyya {
    // https://practice.geeksforgeeks.org/problems/31272eef104840f7430ad9fd1d43b434a4b9596b/1/
    ArrayList<Integer> search(String pattern, String text){
        ArrayList<Integer> list = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int textAscii = 0;
        int patternAscii = 0;
        for (int i = 0; i < m; i++) {
            patternAscii += (pattern.charAt(i));
        }
        for (int i = 0; i < n - m + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < m; j++) {
                    textAscii += (text.charAt(j));
                }
            } else {
                textAscii = textAscii - text.charAt(i - 1) + text.charAt(i + m - 1);
            }
            if (textAscii == patternAscii && isMatch(text, pattern, i))
                list.add(i);
        }
        return list;
    }

    public  boolean isMatch(String text, String pattern, int index) {

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != text.charAt(i + index))
                return false;
        }
        return true;
    }
}
