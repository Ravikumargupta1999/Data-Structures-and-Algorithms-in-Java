import java.util.HashMap;

// https://www.geeksforgeeks.org/k-length-words-that-can-be-formed-from-given-characters-without-repetition/
public class Video_20_Words_K_Selection_5_Ravi {
    public static void main(String[] args) throws Exception {
        String str = "geeksforgeeks";
        int k = 4;
        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (
                char ch : str.toCharArray()) {
            if (!unique.containsKey(ch)) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        fun(ustr, unique, 0, k, "");
        System.out.println("\n\n\nTotal String : "+count);
    }
    static int count = 0;

    public static void fun(String str, HashMap<Character, Integer> fmap, int cs, int ts, String asf) {
        if(cs > ts)
            return;
        if (cs == ts) {
            count++;
            System.out.println(asf);
            return;
        }
        for (char ch : fmap.keySet()) {
            if (fmap.get(ch) > 0) {
                int count = fmap.get(ch);
                fmap.put(ch,0);
                fun(str, fmap, cs + 1, ts, asf + ch);
                fmap.put(ch, count);
            }
        }

    }



}

