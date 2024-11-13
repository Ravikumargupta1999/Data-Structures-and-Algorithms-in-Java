import java.util.HashMap;

public class Maximum_Sub_String_after_at_most_K_changes {
    // https://practice.geeksforgeeks.org/problems/maximum-sub-string-after-at-most-k-changes3220/1?page=1&difficulty[]=1&status[]=unsolved&company[]=Amazon&sortBy=submissions
    // https://leetcode.com/problems/longest-repeating-character-replacement/submissions/
    // https://www.youtube.com/watch?v=gqXU1UyA8pk
    public int characterReplacement(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int maxLength = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char currentCharacter = s.charAt(end);
            map.put(currentCharacter, map.getOrDefault(currentCharacter, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(currentCharacter));

            if (end - start + 1 - maxFrequency > k) {
                char startCharacter = s.charAt(start);
                map.put(startCharacter, map.getOrDefault(startCharacter, 0) - 1);
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
            end++;
        }
        return maxLength;
    }
}
