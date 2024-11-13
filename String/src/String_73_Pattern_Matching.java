public class String_73_Pattern_Matching {
    // https://practice.geeksforgeeks.org/problems/pattern-searching4145/1
    int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i < n - m + 1; i++) {
            if (isMatch(text, pattern, i))
                return 1;
        }
        return 0;
    }

    public boolean isMatch(String text, String pattern, int index) {

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != text.charAt(i + index))
                return false;
        }
        return true;
    }

}
