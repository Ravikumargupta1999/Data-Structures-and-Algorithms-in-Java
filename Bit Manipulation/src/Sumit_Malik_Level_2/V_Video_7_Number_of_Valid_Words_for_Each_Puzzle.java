package Sumit_Malik_Level_2;

import java.util.*;

// https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
public class V_Video_7_Number_of_Valid_Words_for_Each_Puzzle {
    // Brute Force
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        List<HashSet<Character>> sets = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            sets.add(new HashSet<>());
            for (char ch : words[i].toCharArray()) {
                sets.get(i).add(ch);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            list.add(0);
        }

        for (int i = 0; i < puzzles.length; i++) {
            HashSet<Character> parents = new HashSet<>();
            for (char ch : puzzles[i].toCharArray()) {
                parents.add(ch);
            }
            for (int j = 0; j < sets.size(); j++) {
                if (sets.get(j).contains(puzzles[i].charAt(0)) && checkIfContains(parents, sets.get(j))) {
                    list.set(i, list.get(i) + 1);
                }
            }

        }
        return list;
    }

    public boolean checkIfContains(HashSet<Character> parents, HashSet<Character> set) {

        for (char ch : set) {
            if (!parents.contains(ch))
                return false;
        }
        return true;
    }

    // https://www.youtube.com/watch?v=9jV0CC_C26s&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=7


    public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
        int[] word = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int bit = 0;
            for (char ch : words[i].toCharArray()) {
                int pos = ch - 'a';
                bit = bit | (1 << pos);
            }
            word[i] = bit;
        }
        int[] puzzle = new int[puzzles.length];
        for (int i = 0; i < puzzles.length; i++) {
            int bit = 0;
            for (char ch : puzzles[i].toCharArray()) {
                int pos = ch - 'a';
                bit = bit | (1 << pos);
            }
            puzzle[i] = bit;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < puzzle.length; i++) {
            int count = 0;
            for (int j = 0; j < word.length; j++) {
                int p = puzzle[i];
                int w = word[i];
                int firstCharacter = puzzles[i].charAt(0) - 'a';
                int checkMask = (1 << firstCharacter);
                boolean flag = (w & checkMask) == 0 ? false : true;
                if (flag && ((p & w) == w)) {
                    count++;
                }
            }
            list.add(count);
        }
        return list;
    }



}
