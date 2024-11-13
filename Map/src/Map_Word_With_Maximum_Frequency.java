import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Map_Word_With_Maximum_Frequency {
    public static String maximumFrequency(String s) {
        String s1 = "";
        ArrayList<String> al = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                map.put(s1, map.getOrDefault(s1, 0) + 1);
                al.add(s1);
                s1 = "";
            } else {
                s1 = s1 + s.charAt(i);
            }

        }
        map.put(s1, map.getOrDefault(s1, 0) + 1);
        int count = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= count) {
                result = entry.getKey();
                count = entry.getValue();
                if (result.length() < entry.getKey().length()) {
                    result = entry.getKey();
                    // count = entry.getValue();
                }
            }
        }
        for (int i = 0; i < al.size(); i++) {

            if (map.get(al.get(i)) == count) {
                result = al.get(i);
                break;
            }
        }

        return result + " " + count;
    }


    public static void main(String[] args) {
        System.out.println(maximumFrequency("t jbq si d vvd ly d cl wy uer z z ke ax l eqq m gbl hj pi"));
    }

}
