import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Backtracking_288_All_Permutation_Of_String {

    // Valid only for non-repeating string
    static List<String> list = new ArrayList<>();

    public static List<String> find_permutation1(String str) {
        fun(str);
        return list;
    }

    public static void printPermutation(String str, String ansSofar) {
        if (str.length() == 0) {
            list.add(ansSofar);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            // particular char
            char ch = str.charAt(i);

            // left part
            // 1 2 3 4
            String qlPart = str.substring(0, i);

            // right part
            String qrPart = str.substring(i + 1);

            // left + right
            String rop = qlPart + qrPart;
            printPermutation(rop, ansSofar + ch);
        }
    }

    // Valid For duplicate String Also
    public  List<String> find_permutation(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : S.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        List<String> list = new ArrayList<>();
        getPermutation(S.length(), "", map, list);
        return list;
    }

    public void getPermutation(int n, String asf, HashMap<Character, Integer> map, List<String> list) {
        if (asf.length() == n) {
            list.add(asf);
            return;
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                getPermutation(n, asf + ch, map, list);
                map.put(ch, map.get(ch) + 1);
            }
        }
    }

    static void fun(String str) {
        getPerm(str, "", new HashSet<Integer>());
    }

    static void getPerm(String str, String ans, HashSet<Integer> set) {
        if(ans.length() == str.length()){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(i)) {
                set.add(i);
                getPerm(str, ans + str.charAt(i), set);
                set.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        fun("123");
    }

}
