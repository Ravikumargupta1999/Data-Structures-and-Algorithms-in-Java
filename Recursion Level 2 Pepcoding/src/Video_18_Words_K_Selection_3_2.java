import java.util.HashMap;

// https://www.youtube.com/watch?v=0r7PHinJZNY&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=44
public class Video_18_Words_K_Selection_3_2 {

    public static void main(String[] args) throws Exception {
        String str = "aabbbcc";
        int k = 2;

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (!unique.containsKey(ch)) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        fun(ustr, unique, 0, "", k);
    }

    public static void fun(String str, HashMap<Character, Integer> fmap, int idx, String asf, int k) {
        if (k < 0)
            return;
        if (idx == str.length()) {
            if (k == 0)
                System.out.println(asf);
            return;
        }
        char ch = str.charAt(idx);
        if (fmap.get(ch) > 0) {
            fmap.put(ch, fmap.get(ch) - 1);
            fun(str, fmap, idx, asf + ch, k - 1);
            fmap.put(ch, fmap.get(ch) + 1);
        }
        fun(str, fmap, idx + 1, asf, k);
    }

}
