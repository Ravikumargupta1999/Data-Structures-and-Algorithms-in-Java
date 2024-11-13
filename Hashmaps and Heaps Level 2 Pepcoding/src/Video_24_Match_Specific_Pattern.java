import java.util.ArrayList;
import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/match-specific-pattern/1/#
public class Video_24_Match_Specific_Pattern {
    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern) {
        ArrayList<String> list = new ArrayList<>();
        for (String st : dict) {
            if (matched(st, pattern) && matched(pattern, st))
                list.add(st);
        }
        return list;
    }

    public static boolean matched(String res, String pattern) {
        if (res.length() != pattern.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < res.length(); i++) {
            if (map.containsKey(res.charAt(i))) {
                if (map.get(res.charAt(i)) != pattern.charAt(i))
                    return false;
            } else {
                map.put(res.charAt(i), pattern.charAt(i));
            }
//            System.out.println(map);
        }
//        System.out.println("\n");
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        String[] dict = {"abb", "abc", "xyz", "xyy"};
        String pattern = "foo";
        ArrayList<String> al = new ArrayList<>();
        for (String st : dict) {
            al.add(st);
        }
        System.out.println(findMatchedWords(al, pattern));
    }
}
