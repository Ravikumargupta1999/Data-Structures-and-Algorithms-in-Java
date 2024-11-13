package InterviewQuestion;

import java.util.HashMap;
import java.util.HashSet;

public class Video_45_Message_Decoding {
    // https://practice.geeksforgeeks.org/problems/message-decoding4305/1
    public boolean decode(String S)
    {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('h', 0);
        map.put('e', 0);
        map.put('l', 0);
        map.put('o', 0);

        for (char ch : S.toCharArray()) {
            if (map.containsKey(ch)) {
                addIfPossible(map, ch, "helo");
            }
        }
        for (char ch : map.keySet()) {
            if (ch == 'l' && map.get(ch) < 2)
                return false;
            else if (map.get(ch) < 1)
                return false;
        }
        return true;
    }

    public void addIfPossible(HashMap<Character, Integer> map, char ch, String str) {
        if (ch == 'h')
            map.put(ch, 1);
        else if (ch == 'e') {
            if (map.get('h') < 1)
                return;
            map.put(ch, map.get(ch) + 1);
        } else if (ch == 'l') {
            if (map.get('h') < 1 || map.get('e') < 1)
                return;
            map.put(ch, map.get(ch) + 1);
        }else if(ch == 'o'){
            if (map.get('h') < 1 || map.get('e') < 1 || map.get('l') < 2)
                return;
            map.put(ch, map.get(ch) + 1);
        }
    }
}
