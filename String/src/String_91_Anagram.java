import java.util.Arrays;
import java.util.HashMap;

public class String_91_Anagram {
    // https://practice.geeksforgeeks.org/problems/anagram-1587115620/1#
    // https://leetcode.com/problems/valid-anagram/
    // Accepted on both leetcode and GFG
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char ch : a.toCharArray())
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        for (char ch : b.toCharArray())
            map1.put(ch, map1.getOrDefault(ch, 0) - 1);
        for (char ch : map1.keySet()) {
            if (map1.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }

    // Wrong on both leetcode and gfg
    public static boolean isAnagram1(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char ch : str1.toCharArray())
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char ch : str2.toCharArray())
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        return compare(map1, map2) && compare(map2,map1);
    }

    public static boolean compare(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (char ch : map1.keySet()) {
           if(!map2.containsKey(ch))
               return false;
           if(map2.get(ch) != map1.get(ch))
               return false;
        }
        return true;
    }


    // https://practice.geeksforgeeks.org/problems/java-anagram-strings3549/0/?category[]=Java&category[]=Java&page=1&sortBy=accuracy&query=category[]Javapage1sortByaccuracycategory[]Java#

    static int areAnagram(String a, String b) {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int NO_OF_CHARS = 256;
        int count1[] = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;

        for (i = 0; i < str1.length && i < str2.length;
             i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        if (str1.length != str2.length)
            return 0;


        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return 0;

        return 1;
    }
    // https://practice.geeksforgeeks.org/problems/anagram-1587115620/1
    public static boolean areAnagrams(String a,String b)
    {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int NO_OF_CHARS = 256;
        int count1[] = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;

        for (i = 0; i < str1.length && i < str2.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        if (str1.length != str2.length)
            return false;


        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }
}
