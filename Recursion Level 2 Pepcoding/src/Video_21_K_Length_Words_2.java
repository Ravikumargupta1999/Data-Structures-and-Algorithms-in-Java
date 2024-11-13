import java.util.HashSet;

public class Video_21_K_Length_Words_2 {
    public static void main(String[] args) {

        String str = "geeksforgeeks";
        int k = 3;
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (!unique.contains(ch)) {
                unique.add(ch);
                ustr += ch;
            }
        }
        fun(1, k, ustr, new HashSet<>(), "");
        System.out.println(count);

    }
    static int count = 0;
    public static void fun(int cs, int ts, String ustr, HashSet<Character> set, String asf) {
        if (cs > ts) {
            count++;
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                fun(cs + 1, ts, ustr, set, asf + ch);
                set.remove(ch);
            }
        }
    }

}
