package Day_9_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partitionPalindrome(0, s, temp, res);
        return res;
    }

    public void partitionPalindrome(int index, String str, List<String> temp, List<List<String>> res) {
        if (index == str.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        String left = "";
        for (int i = index; i < str.length(); i++) {
            left += str.charAt(i);
            if (isPalindrome(left)) {
                temp.add(left);
                partitionPalindrome(i + 1, str, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
