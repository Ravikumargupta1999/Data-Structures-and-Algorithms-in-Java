import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Video_42_Word_Pattern_Matching {

    public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {
        if (pattern.length() == 0) {
            if (str.length() == 0) {
                HashSet<Character> set = new HashSet<>();
                for (int i = 0; i < op.length(); i++) {
                    char ch = op.charAt(i);
                    if (!set.contains(ch)) {
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                        set.add(ch);
                    }
                }
                System.out.println(".");
            }
            return;
        }
        char ch = pattern.charAt(0);
        String ros = pattern.substring(1);
        if (map.containsKey(ch)) {
            String previousMapping = map.get(ch);
            if (str.length() >= previousMapping.length()) {
                String left = str.substring(0, previousMapping.length());
                String right = str.substring(previousMapping.length());
                if (previousMapping.equals(left)) {
                    solution(right, ros, map, op);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);
                map.put(ch, left);
                solution(right, ros, map, op);
                map.remove(ch);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap<Character, String> map = new HashMap<>();
        solution(str, pattern, map, pattern);
    }
}
