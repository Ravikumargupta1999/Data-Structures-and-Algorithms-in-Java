import java.util.Arrays;

  // https://www.geeksforgeeks.org/maximum-trains-stoppage-can-provided/
  // https://www.youtube.com/watch?v=naDecrj9Cyc&t=548s
public class Greedy_244_Maximum_trains_for_which_stoppage_can_be_provided {
    public static int maxStop(int[][] trains, int n, int m) {
        int count = 0;

        // Sort Array based on departure time
        Arrays.sort(trains, (a, b) -> {
            return a[1] - b[1];
        });

        boolean[] platform = new boolean[n];
        int[] departure = new int[n];

        Arrays.fill(departure, -1);

        for (int[] train : trains) {
            int start = train[0];
            int end = train[1];
            int plat = train[2];

            // if first train coming on platform
            if (!platform[plat]) {
                count++;
                platform[plat] = true;
                departure[plat] = end;
            }

            // if new arrived train have greater than equal to end time
            else if (departure[plat] <= start) {
                count++;
                departure[plat] = end;
            }
        }
        return count;
    }
}
