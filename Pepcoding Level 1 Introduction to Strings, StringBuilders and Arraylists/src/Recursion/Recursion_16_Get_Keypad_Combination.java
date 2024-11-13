package Recursion;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//https://www.geeksforgeeks.org/find-possible-words-phone-digits/

import java.util.ArrayList;
import java.util.List;

public class Recursion_16_Get_Keypad_Combination {
    public static List<String> letterCombinations(String str) {

        if (str.length() == 0)
            return new ArrayList<>();
        ArrayList<String> al = new ArrayList<>();
        String[] map = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        solve1(al, str, "", 0, map);
        return al;
    }

    public static void solve1(ArrayList<String> al, String str, String current, int i, String[] map) {
        if (i == str.length()) {
            al.add(current);
            return;
        }
        String letter = map[str.charAt(i) - '0'];
        for (int j = 0; j < letter.length(); j++)
            solve1(al, str, current + letter.charAt(j), i + 1, map);
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

}
