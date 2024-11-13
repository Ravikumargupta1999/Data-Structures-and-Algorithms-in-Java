package hhhhhhhhhhh;

import java.util.Arrays;
import java.util.HashSet;

public class P2 {
    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(vowelStrings(words,queries)));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        boolean[] isVowel = new boolean[words.length];
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = 0; i < words.length; i++) {
            isVowel[i] = set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1));
        }

        int[] prefix = new int[words.length];
        prefix[0] = isVowel[0] ? 1 : 0;
        for (int i = 1; i < words.length; i++) {

            prefix[i] = prefix[i - 1];
            if (isVowel[i])
                prefix[i]++;
        }
        System.out.println(Arrays.toString(prefix));
        int[] temp = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            temp[i] = prefix[b];
            temp[i] -= (a == 0 ? 0 : prefix[a-1]);
        }
        return temp;
    }
}
