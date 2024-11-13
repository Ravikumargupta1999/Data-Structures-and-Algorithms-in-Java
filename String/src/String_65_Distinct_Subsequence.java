import java.util.*;

public class String_65_Distinct_Subsequence {
    public static List<String> getSubsequence(String str) {
        if (str.length() == 0) {
            List<String> al = new ArrayList<>();
            al.add("");
            return al;
        }
        char ch = str.charAt(0);
        String temp = str.substring(1);
        List<String> remainingResult = getSubsequence(temp);
        List<String> result = new ArrayList<>();
        for (String s : remainingResult) {
            result.add("" + s);
            result.add(ch + s);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ggg";
        List<String> result = getSubsequence(str);
        // result.remove(0);
        System.out.println(result);
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < result.size(); i++)
            map.put(result.get(i), 1);
        System.out.println(map.size());
        System.out.println(result);

    }
}
