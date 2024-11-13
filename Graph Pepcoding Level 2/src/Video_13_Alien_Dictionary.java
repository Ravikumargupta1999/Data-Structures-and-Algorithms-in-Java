import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/alien-dictionary/1#
// https://www.youtube.com/watch?v=_u1Mn4_2hIo&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=13
public class Video_13_Alien_Dictionary {
    public String findOrder(String[] dict, int N, int K) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for (String st : dict) {
            for (char ch : st.toCharArray()) {
                inDegree.put(ch, 0);
            }
        }

        // boolean flag = false;

        for (int i = 0; i < dict.length - 1; i++) {

            String curr = dict[i];
            String next = dict[i + 1];

            int len = Math.min(curr.length(), next.length());

            for (int j = 0; j < len; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);

                if (ch1 != ch2) {
                    HashSet<Character> set = new HashSet<>();
                    if (map.containsKey(ch1)) {
                        set = map.get(ch1);
                        if (!set.contains(ch2)) {
                            set.add(ch2);
                            inDegree.put(ch2, inDegree.get(ch2) + 1);
                            map.put(ch1, set);
                        }
                    } else {
                        set.add(ch2);
                        inDegree.put(ch2, inDegree.get(ch2) + 1);
                        map.put(ch1, set);
                    }

                    break;
                }

            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : inDegree.keySet()) {
            if (inDegree.get(ch) == 0)
                queue.add(ch);
        }

        int count = 0;
        while (queue.size() > 0) {
            char rem = queue.poll();
            sb.append(rem);
            count++;
            if (map.containsKey(rem)) {
                HashSet<Character> neighbours = map.get(rem);
                for (char nbr : neighbours) {
                    inDegree.put(nbr, inDegree.get(nbr) - 1);
                    if (inDegree.get(nbr) == 0)
                        queue.add(nbr);
                }
            }
        }
        if (count == inDegree.size())
            return sb.toString();
        return "";
    }
}
