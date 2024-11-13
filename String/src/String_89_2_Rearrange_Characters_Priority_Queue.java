import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;


// https://practice.geeksforgeeks.org/contest/coding-try-outs-amazon/problems
// https://practice.geeksforgeeks.org/problems/rearrange-characters4649/1/
// https://www.youtube.com/watch?v=zaM_GLLvysw
public class String_89_2_Rearrange_Characters_Priority_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str = read.readLine();
            HashMap<Character, Integer> counts = new HashMap<>();
            for (char ch : str.toCharArray()) {
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            }
            PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
                return counts.get(b) - counts.get(a);
            });
            maxHeap.addAll(counts.keySet());
            StringBuffer sb = new StringBuffer();
            while (maxHeap.size() > 1) {
                char current = maxHeap.remove();
                char next = maxHeap.remove();
                sb.append(current);
                sb.append(next);
                counts.put(current, counts.get(current) - 1);
                counts.put(next, counts.get(next) - 1);
                if (counts.get(current) > 0)
                    maxHeap.add(current);
                if (counts.get(next) > 0)
                    maxHeap.add(next);
            }
            if (!maxHeap.isEmpty()) {
                char last = maxHeap.remove();
                if (counts.get(last) > 1)
                    System.out.println("0");
                else
                    System.out.println("1");
            } else {
                System.out.println("1");
            }
        }
    }

    // https://leetcode.com/problems/reorganize-string/
    public String reorganizeString(String str) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
            return counts.get(b) - counts.get(a);
        });
        maxHeap.addAll(counts.keySet());
        StringBuffer sb = new StringBuffer();
        while (maxHeap.size() > 1) {
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            sb.append(current);
            sb.append(next);
            counts.put(current, counts.get(current) - 1);
            counts.put(next, counts.get(next) - 1);
            if (counts.get(current) > 0)
                maxHeap.add(current);
            if (counts.get(next) > 0)
                maxHeap.add(next);
        }
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (counts.get(last) > 1)
                return "";
            else{
                sb.append(last);
                return sb.toString();
            }
        } else {
            return sb.toString();
        }
    }
}
