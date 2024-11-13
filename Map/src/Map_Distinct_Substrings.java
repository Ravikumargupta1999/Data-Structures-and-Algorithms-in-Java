import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/distinct-substrings2516/1/?category[]=Map&category[]=Map&page=2&query=category[]Mappage2category[]Map#
public class Map_Distinct_Substrings {
    static int fun(String s) {
        System.out.println(s.length());
        int count = 0;
        HashSet<String> hm = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {

            String temp = "" + s.charAt(i) + s.charAt(i + 1);

            if (hm.contains(temp))
                continue;
            else {
                String str = "";
                str = str + s.charAt(i) + s.charAt(i + 1);
                hm.add(str);
                count++;
                System.out.println(str + "  " + count);
            }


        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(fun("WLRBBMQBHCDARZOWKKYHIDDQSCDXRJMO"));
    }
}
