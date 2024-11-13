import java.util.HashMap;

// https://www.geeksforgeeks.org/print-all-combinations-of-given-length/
public class Video_20_Strings_of_length_k_that_can_be_formed_from_a_set_of_n_characters {

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
//set[]={'a','b'},k=3