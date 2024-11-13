import java.util.ArrayList;

public class Practice_20_Closest_Strings {
    int shortestDistance(ArrayList<String> strings, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int d1 = -1;
        int d2 = -1;

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equals(word1))
                d1 = i;
            if (strings.get(i).equals(word2))
                d2 = i;
            if (d1 != -1 && d2 != -1) {
                min = Math.min(min, Math.abs(d1 - d2));
            }
        }
        return min;
    }
}
