import java.util.HashSet;
// https://www.youtube.com/watch?v=fy5mFaHVuRs&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=27
public class Video_17_Words_K_Selection_2_Select_K_Distinct_Characters_Without_Repetition {

    public static void generateSelection(String uniqueString, int cs, int ts, int lc, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (int i = lc + 1; i < uniqueString.length(); i++) {
            generateSelection(uniqueString, cs + 1, ts, i, asf + uniqueString.charAt(i));
        }
    }

    public static void main(String[] args) throws Exception {
        String str = "aabbbcc";
        int k = 2;
        HashSet<Character> unique = new HashSet<>();
        String uniqueString = "";
        for (char ch : str.toCharArray()) {
            if (!unique.contains(ch)) {
                unique.add(ch);
                uniqueString += ch;
            }
        }

        generateSelection(uniqueString, 1, k, -1, "");
    }
}
