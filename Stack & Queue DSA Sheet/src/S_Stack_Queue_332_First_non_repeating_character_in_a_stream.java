import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://www.youtube.com/watch?v=gbASJJAvAGk
// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
public class S_Stack_Queue_332_First_non_repeating_character_in_a_stream {
    public String FirstNonRepeating(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            queue.add(ch);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (!queue.isEmpty()) {
                if (map.get(queue.peek()) > 1)
                    queue.remove();
                else {
                    ans.append(queue.peek());
                    break;
                }
            }
            if (queue.isEmpty())
                ans.append("#");
        }
        return ans.toString();
    }

}
