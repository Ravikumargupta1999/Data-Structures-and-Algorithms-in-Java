
// Done
import java.util.HashMap;
import java.util.Map;


public class String_58_Duplicate_Character_In_String {

    public static void duplicates1(String str){
        int[] arr = new int[26];
        for (char ch : str.toCharArray())
            arr[ch-'a']++;
        for (int i=0;i<26;i++){
            if(arr[i] > 1)
            {
                char ch = (char) ('a' + i);
                System.out.println(ch+"  "+arr[i]);
            }
        }
    }

    public static void duplicates(String str) {

        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (mp.containsKey(str.charAt(i))) {
                mp.put(str.charAt(i), mp.get(str.charAt(i)) + 1);
            } else {
                mp.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > 1 && entry.getKey() != ' ')
                System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}
