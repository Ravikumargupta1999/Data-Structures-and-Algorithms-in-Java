import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1
public class Video_20_Check_if_two_Strings_are_K_Anagrams {
    boolean areKAnagrams(String str1, String str2, int k) {
        if (str1.length() != str2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++)
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);

        for (int i = 0; i < str2.length(); i++)
            if (map.getOrDefault(str2.charAt(i), 0) > 0)
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);

        int count = 0;
        for (char ch : map.keySet())
            count += map.get(ch);
        if (count > k)
            return false;
        else
            return true;
    }
}
