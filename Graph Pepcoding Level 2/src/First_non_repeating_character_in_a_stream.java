import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
public class First_non_repeating_character_in_a_stream {
    public String FirstNonRepeating(String a)
    {
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char ch :a.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch) == 1)
                queue.add(ch);
            while (!queue.isEmpty())
            {
                char val = queue.peek();
                if(map.get(val) == 1)
                    break;
                else
                    queue.remove();
            }
            if(!queue.isEmpty())
            {
                sb.append(queue.peek());
            }
            else
            {
                sb.append('#');
            }
        }
        return sb.toString();
    }
}
