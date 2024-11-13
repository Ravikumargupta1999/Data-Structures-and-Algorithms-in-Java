public class First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray())
            freq[ch-'a']++;
        int i = 0;;
        for (char ch : s.toCharArray())
            if(freq[ch-'a'] == 1)
                return i;
            else
                i++;
        return -1;
    }
}
