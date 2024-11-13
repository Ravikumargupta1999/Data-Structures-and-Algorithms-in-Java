import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words_k_selection_1%20/topic
// https://www.youtube.com/watch?v=PiwttDa5FMA&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=26
public class Video_16_Words_K_Selection_1_Select_K_Distinct_Characters_without_Repetition {
    public static void generateSelection(int i, String ustr, int ssf, int ts, String asf) {
        if (i == ustr.length()) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(i);
        generateSelection(i + 1, ustr, ssf + 1, ts, asf + ch);
        generateSelection(i + 1, ustr, ssf, ts, asf + "");
    }

    public static void main(String[] args) throws Exception {

        String str = "cat";
        int k = 3;

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (!unique.contains(ch)) {
                unique.add(ch);
                ustr += ch;
            }
        }

        generateSelection(0, ustr, 0, k, "");
    }
}
//    abc
//            abd
//    abe
//            acd
//    ace
//            ade
//    bcd
//            bce
//    bde
//            cde