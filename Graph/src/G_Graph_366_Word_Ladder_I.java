import java.util.*;

public class G_Graph_366_Word_Ladder_I {
    // https://www.youtube.com/watch?v=ZVJ3asMoZ18
    // https://practice.geeksforgeeks.org/problems/word-ladder/1/
    // https://leetcode.com/problems/word-ladder/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> map = new HashSet<>();
        for (String word : wordList) {
            map.add(word);
        }
        if (!map.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int depth = 0;
        while (!q.isEmpty()) {
            depth += 1;
            int lSize = q.size();
            while (lSize-- != 0) {
                String curr = q.poll();
                for (int i = 0; i < curr.length(); ++i) {
                    String temp = curr;
                    for (char c = 'a'; c <= 'z'; ++c) {

                        char[] myNameChars = temp.toCharArray();
                        myNameChars[i] = c;
                        temp = String.valueOf(myNameChars);
                        if (temp.equals(curr))
                            continue;
                        if (temp.equals(endWord))
                            return depth + 1;
                        if (map.contains(temp)) {
                            q.add(temp);
                            map.remove(temp);
                        }
                    }
                }
            }
        }
        return 0;

    }
}
