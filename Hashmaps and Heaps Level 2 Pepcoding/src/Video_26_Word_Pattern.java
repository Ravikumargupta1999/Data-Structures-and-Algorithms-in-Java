import java.util.HashMap;
//https://leetcode.com/problems/word-pattern/
public class Video_26_Word_Pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] res = s.split(" ");
        return res.length == pattern.length() && check1(res, pattern) && check2(pattern, res);
    }

    boolean check1(String[] res, String pattern) {
        HashMap<String, Character> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            if (map.containsKey(res[i])) {
                if (map.get(res[i]) != pattern.charAt(i))
                    return false;
            } else {
                map.put(res[i], pattern.charAt(i));
            }
        }
        return true;
    }

    boolean check2(String pattern, String[] res) {
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
//            System.out.println(map);
//            System.out.println(pattern.charAt(i) + "  " + res[i]);
            if (map.containsKey(pattern.charAt(i))) {
//                String str1 = map.get(pattern.charAt(i));
//                String str2 = res[i];
                if (!map.get(pattern.charAt(i)).equals(res[i]))
                    return false;


            } else {
                map.put(pattern.charAt(i), res[i]);
            }
        }
//        System.out.println("\n\n");
        return true;
    }

    public static void main(String[] args) {
//        "abba"
//        "dog cat cat dog"
        String str1 = "abba";
        String str2 = "dog cat cat dog";
        Video_26_Word_Pattern a = new Video_26_Word_Pattern();
        System.out.println(a.wordPattern(str1, str2));
    }

}
