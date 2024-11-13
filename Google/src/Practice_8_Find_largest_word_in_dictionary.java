import java.util.List;
//https://practice.geeksforgeeks.org/problems/find-largest-word-in-dictionary2430/1/?company[]=Google&company[]=Google&difficulty[]=0&page=2&query=company[]Googledifficulty[]0page2company[]Google

public class Practice_8_Find_largest_word_in_dictionary {
    static String findLongestWord(String str, List<String> dict) {
        String result = "";
        int length = 0;
        for (String word : dict) {
            if (length <= word.length() && isSubSequence(word, str)) {
                if (length == word.length()) {
                    if (word.compareTo(result) < 0)
                        result = word;
                    else
                        continue;
                }
                result = word;
                length = word.length();
            }
        }
        return result;
    }

    static boolean isSubSequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (str1.charAt(j) == str2.charAt(i)) {
                j++;
            }
        }
        return (j == m);
    }


}
