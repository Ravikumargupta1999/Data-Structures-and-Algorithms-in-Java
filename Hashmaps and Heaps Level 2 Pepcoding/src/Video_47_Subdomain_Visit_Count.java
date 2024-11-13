import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/subdomain-visit-count/
public class Video_47_Subdomain_Visit_Count {
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String temp : cpdomains) {
            String[] str = temp.split(" ");
            int count = Integer.parseInt(str[0]);
            temp = str[1];
            map.put(temp, map.getOrDefault(temp, 0) + count);

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '.')
                    continue;
                if (i != temp.length() - 1 && temp.charAt(i + 1) == '.') {
                    map.put(temp.substring((i + 2)), map.getOrDefault(temp.substring(i + 2), 0) + count);
                }
            }
        }
        List<String> arrayList = new ArrayList<>();
        for (String str : map.keySet()) {
            arrayList.add(map.get(str) + " " + str);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        String[] cpDomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpDomains));
    }
}
