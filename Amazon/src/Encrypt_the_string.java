import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/encrypt-the-string-10337/1

public class Encrypt_the_string {
    static String encryptString(String s) {
        Map<Character,Integer> counts = new HashMap<>();
        for(char c : s.toCharArray())
        {
            counts.put(c,counts.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());
        System.out.println(maxHeap);

        String result  = "";
        while (maxHeap.size() >= 1) {
            char current = maxHeap.remove();
            result = result+ current + counts.get(current);
            System.out.println(counts.get(current));
        }
        int i = result.length()-1;
        String temp = "";
        while (i>=0) {
            temp = temp + result.charAt(i);
            i--;
        }
        return temp;

    }

    public static void main(String[] args) {
        System.out.println(encryptString("aabc"));
    }
}
