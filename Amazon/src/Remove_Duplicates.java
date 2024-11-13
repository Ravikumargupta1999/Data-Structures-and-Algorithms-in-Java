import java.util.HashMap;

public class Remove_Duplicates {
    //https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft

    String removeDups(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                sb.append(s.charAt(i));
                map.remove(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
