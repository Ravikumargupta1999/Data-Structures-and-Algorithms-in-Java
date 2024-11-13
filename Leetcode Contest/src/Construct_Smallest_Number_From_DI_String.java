import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Construct_Smallest_Number_From_DI_String {
    public String smallestNumber(String pattern) {
        List<String> res = new ArrayList<>();
        res.add("99999999999");
        HashSet<Character> set = new HashSet<>();
        for (char i = '1'; i <= '9'; i++) {
            set.add(i);
            getSmallestNumber(pattern, pattern.length() - 1, Character.getNumericValue(i) + "", i, set, res);
            set.remove(i);
        }
        return res.get(0);
    }

    public void getSmallestNumber(String pattern, int index, String res, char digit, HashSet<Character> set, List<String> list) {
        if (index < 0) {
//            System.out.println(res);
            if (String.valueOf(res).compareTo(list.get(0)) < 0) {
                list.set(0, res);
            }
            return;
        }
        if (pattern.charAt(index) == 'I') {
            for (char i = '1'; i <= '9'; i++) {
                if (set.contains(i))
                    continue;
                if (i < digit) {
                    set.add(i);
                    getSmallestNumber(pattern, index - 1, i + "" + res, i, set, list);
                    set.remove(i);
                }
            }
        } else {
            for (char i = '1'; i <= '9'; i++) {
                if (set.contains(i))
                    continue;
                if (i > digit) {
                    set.add(i);
                    getSmallestNumber(pattern, index - 1, i + "" + res, i, set, list);
                    set.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
//        pattern = "IIIDIDDD"
//        Output: "123549876"
        String str = "IIIIIIII";
        System.out.println(new Construct_Smallest_Number_From_DI_String().smallestNumber(str));
    }
}
