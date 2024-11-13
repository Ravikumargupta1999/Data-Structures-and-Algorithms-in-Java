import javafx.util.Pair;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.PrintWriter;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1/?company[]=Adobe&company[]=Adobe&page=1&query=company[]Adobepage1company[]Adobe

public class Winner_Of_An_Election {

    public static String[] winner(String arr[], int n) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        int maxValueInMap = 0;
        String winner = "";
        for (Map.Entry<String,Integer> entry : map.entrySet())
        {
            String key  = entry.getKey();
            Integer val = entry.getValue();
            if (val > maxValueInMap)
            {
                maxValueInMap = val;
                winner = key;
            }
            else if (val == maxValueInMap && winner.compareTo(key) > 0)
                winner = key;
        }
        String[] str = new String[2];
        str[0] = winner;
        str[1] = ""+ map.get(winner);
        return str;

    }

    public static void main(String[] args) {
        int n = 13;
        String Votes[] = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
        String[] s = winner(Votes, n);
        System.out.println(s[0]+" "+s[1]);
    }
}
