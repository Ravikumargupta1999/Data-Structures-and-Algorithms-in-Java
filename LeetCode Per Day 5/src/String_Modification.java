import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class String_Modification {

    public String reorganizeString(String s) {
        Map<Character,Integer> counts = new HashMap<>();
        for(char c : s.toCharArray())
        {
            counts.put(c,counts.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1)
        {
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            result.append(current);
            result.append(next);
            counts.put(current,counts.get(current)-1);
            counts.put(next,counts.get(next)-1);

            if(counts.get(current) > 0)
                maxHeap.add(current);

            if(counts.get(next) > 0)
                maxHeap.add(next);
        }
        if(!maxHeap.isEmpty())
        {
            char last = maxHeap.remove();
            int total = counts.get(last);
            while (total-- > 0)
                result.append(last);

        }
        return result.toString();
    }
}
