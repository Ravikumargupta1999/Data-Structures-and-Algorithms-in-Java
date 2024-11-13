import java.util.*;


public class Greedy_271_Rearrange_Character {
    // https://practice.geeksforgeeks.org/problems/rearrange-characters4649/1/
    public static String rearrangeCharacters(String str) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
            return counts.get(b) - counts.get(a);
        });
        maxHeap.addAll(counts.keySet());
        StringBuffer sb = new StringBuffer();
        // System.out.println(maxHeap);
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
                return "-1";
            else
                return sb.toString() + last;
        } else {
            return sb.toString();
        }
    }

    // https://practice.geeksforgeeks.org/problems/rearrange-a-string4100/1/
    public String arrangeString(String s)
    {
        int[] arr = new int[26];
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c))
                arr[c - 'A']++;
            else
                sum += Character.getNumericValue(c);
        }
        String str = "";
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i]; j++) {
                str += (char)('A' + i);
            }
        }
        if( sum == 0)
            return str;
        return str + sum;
    }
}
