import java.util.*;

// https://practice.geeksforgeeks.org/problems/power-set4302/1
public class String_65_Get_Subsequence {
    public static List<String> getSubsequence(String str) {
        if (str.length() == 0) {
            List<String> al = new ArrayList<>();
            al.add("");
            return al;
        }
        char ch = str.charAt(0);
        String temp = str.substring(1);
        List<String> res = getSubsequence(temp);
        List<String> result = new ArrayList<>();
        for (String s : res) {
            result.add("" + s);
            result.add(ch + s);
        }
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return result;
    }

}
