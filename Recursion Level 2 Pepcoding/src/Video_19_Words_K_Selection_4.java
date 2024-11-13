import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://www.youtube.com/watch?v=SwXwACWqKTA&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=44
public class Video_19_Words_K_Selection_4 {
    public static void main(String[] args) throws Exception {


        String str = "geeksforgeeks";
        int k = 4;


        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (
                char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        fun(ustr, unique, 0, k, "", 0);
    }

    public static void fun(String str, HashMap<Character, Integer> fmap, int cs, int ts, String asf, int lcui) {
        if (cs > ts)
            return;
        if (cs == ts) {
            System.out.println(asf);
            return;
        }
        for (int i = lcui; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (fmap.get(ch) > 0) {
                fmap.put(ch, fmap.get(ch) - 1);
                fun(str, fmap, cs + 1, ts, asf + ch, i);
                fmap.put(ch, fmap.get(ch) + 1);
            }
        }

    }
}
