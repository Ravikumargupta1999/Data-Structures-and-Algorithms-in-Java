package Day_16_String_II;

public class Check_For_Anagrams {
    // https://leetcode.com/problems/valid-anagram/submissions/
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray())
            arr[ch-'a']++;
        for (char ch : t.toCharArray())
            arr[ch-'a']--;
        for (int val : arr)
            if(val != 0)
                return false;
        return true;
    }
}
