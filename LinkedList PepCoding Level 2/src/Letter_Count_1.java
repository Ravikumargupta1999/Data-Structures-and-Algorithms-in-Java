import java.util.ArrayList;
import java.util.HashMap;

public class Letter_Count_1 {
    static String function(String str) {
        ArrayList<String> al = new ArrayList();
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ',' || ch == ' ' || ch == '!') {
                if (temp.length() > 1)
                    al.add(temp);
                temp = "";
            } else
                temp = temp + ch;
        }
        al.add(temp);
        System.out.println(al);
        String ans = "";
        int resans = 1;
        for (int i = 0; i < al.size(); i++) {
            String s = al.get(i);
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j)))
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                else
                    map.put(s.charAt(j), 1);
            }
            int count;
            for (int j = 0; j < s.length(); j++) {
                if (map.get(s.charAt(j)) > resans) {
                    resans = map.get(s.charAt(j));
                    ans = s;
                } else
                    continue;
            }
        }
        return ans.length() > 1 ? ans : "-1";

    }

    public static void main(String[] args) {
        System.out.println(function("Today,is the greatest  day ever"));
    }
}
