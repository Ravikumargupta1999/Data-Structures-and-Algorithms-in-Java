import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Minimize_String_Value {
    int minValue(String s,int K) {
        // code here
        Map<Character,Integer> counts = new HashMap<>();
        for(char c : s.toCharArray())
        {
            counts.put(c,counts.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());
        StringBuilder result = new StringBuilder();
        while (K-- > 0 && maxHeap.size() > 0)
        {
            char current = maxHeap.remove();
            result.append(current);

            counts.put(current,counts.get(current)-1);

            if(counts.get(current) > 0)
                maxHeap.add(current);

        }
        int ans = 0;
        for ( char ch : counts.keySet())
            ans += (counts.get(ch)*counts.get(ch));
        return ans;
    }
}
