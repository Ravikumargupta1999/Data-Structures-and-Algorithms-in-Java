import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode_30_Substring_with_Concatenation_of_All_Words {

    // https://leetcode.com/problems/substring-with-concatenation-of-all-words/
    // TLE
    public static void main(String[] args) {
        String s = "foobarfoobar";
        String[] arr = {"foo", "bar"};
        Leetcode_30_Substring_with_Concatenation_of_All_Words a = new Leetcode_30_Substring_with_Concatenation_of_All_Words();
        System.out.println(a.findSubstring(s, arr));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<List<String>> list = permute(words);
        System.out.println(list);
        List<Integer> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (List<String> list1 : list) {
            StringBuilder sb = new StringBuilder();
            for (String word : list1) {
                sb.append(word);
            }

            if (!set.contains(sb.toString())) {
                List<Integer> temp = getPattern(s,sb.toString());
                for(int val : temp)
                    res.add(val);
            }
            set.add(sb.toString());
        }
        return res;
    }

    public List<List<String>> permute(String[] arr) {
        List<String> temp = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        permutations(arr, temp, list, new boolean[arr.length]);
        return list;
    }

    public void permutations(String[] arr, List<String> temp, List<List<String>> list, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(arr[i]);
                permutations(arr, temp, list, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static List<Integer> getPattern(String str, String pat) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int temp = i;
            int j = 0;
            for (j = 0; j < pat.length() & temp < str.length(); j++, temp++) {
                if (str.charAt(temp) != pat.charAt(j))
                    break;
            }
            if (j == pat.length())
                list.add(i);
        }
        return list;
    }


    //    https://practice.geeksforgeeks.org/problems/pattern-searching5231/1
    public static boolean searchPattern(String str, String pat) {
        for (int i = 0; i < str.length(); i++) {
            int temp = i;
            int j = 0;
            for (j = 0; j < pat.length() & temp < str.length(); j++, temp++) {
                if (str.charAt(temp) != pat.charAt(j))
                    break;
            }
            if (j == pat.length())
                return true;
        }
        return false;
    }
}
