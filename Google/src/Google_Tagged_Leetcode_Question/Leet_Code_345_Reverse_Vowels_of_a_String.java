package Google_Tagged_Leetcode_Question;

import java.util.ArrayList;
import java.util.HashSet;

public class Leet_Code_345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        ArrayList<Character> al = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch))
                al.add(ch);
        }
        reverseArrayList(al);
        StringBuilder sb = new StringBuilder();
        System.out.println(al);
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
//                System.out.println(i);
                sb.append(al.get(i));
                i++;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void reverseArrayList(ArrayList<Character> al) {
        int i = 0;
        int j = al.size() - 1;
        while (i < j) {
            char temp = al.get(i);
            al.set(i, al.get(j));
            al.set(j, temp);
            i++;
            j--;
        }

    }
}
