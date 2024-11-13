import java.util.HashMap;

public class String_84_Second_Most_Repeated_String_In_A_Sequence {

    // https://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1#
    static String secFrequent(String[] arr, int N) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : arr)
            map.put(str, map.getOrDefault(str, 0) + 1);
        int max = 0;
        String temp = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                temp = key;
            }
        }
        map.remove(temp);
        max = 0;
        temp = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                temp = key;
            }
        }
        return temp;
    }
}
//N = 6
//arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
// Output: bbb
//
//6
//geeks for geeks for geeks aaa
// https://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1#