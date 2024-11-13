import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Video_15_Permutations_of_a_String_Part_2 {
    public static List<String> permutation(String str) {
        Character[] spots = new Character[str.length()];
        HashMap<Character, Integer> lastOccurance = new HashMap<>();
        for (char ch : str.toCharArray())
            lastOccurance.put(ch, -1);
        generate(0, str, spots, lastOccurance);
        Collections.sort(ans);
        return ans;
    }

    static List<String> ans = new ArrayList<>();

    public static void generate(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurance) {
        if (cc == str.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < spots.length; i++) {
                sb.append(spots[i]);
            }
            ans.add(sb.toString());
            return;
        }
        char ch = str.charAt(cc);
        int lo = lastOccurance.get(ch);
        for (int i = lo + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                int v = lastOccurance.get(ch);
                lastOccurance.put(ch, i);
                generate(cc + 1, str, spots, lastOccurance);
                spots[i] = null;
                lastOccurance.put(ch, v);

            }
        }
    }

    public static void main(String[] args) {
        String str = "ljr";
        System.out.println(permutation(str));
    }
}
