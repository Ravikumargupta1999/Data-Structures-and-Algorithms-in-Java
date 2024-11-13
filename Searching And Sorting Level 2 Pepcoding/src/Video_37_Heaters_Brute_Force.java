import java.util.Arrays;

public class Video_37_Heaters_Brute_Force {
    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);
        int ans = 0;
        for (int e : houses) {
            int min = Integer.MAX_VALUE;
            for (int v : heaters) {
                min = Math.min(min, Math.abs(e - v));
            }
            ans = Math.max(ans, min);
        }
        return ans;
    }
}
