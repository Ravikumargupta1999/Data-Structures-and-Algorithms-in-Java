import java.util.HashMap;
// https://www.youtube.com/watch?v=SwXwACWqKTA&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=44
public class Video_18_Words_K_Selection_3_1 {
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

    public static void fun(String str, HashMap<Character, Integer> frequencyMap, int idx, String asf, int k) {
        if (k < 0)
            return;
        if (idx == str.length()) {
            if (k == 0)
                System.out.println(asf);
            return;
        }
        char ch = str.charAt(idx);
        for (int i = frequencyMap.get(ch);i>=0;i--){
            String s = "";
            for (int j=0;j<i;j++){
                s += ch;
            }
            fun(str,frequencyMap,idx+1,asf + s,k-i);
        }
    }
}
