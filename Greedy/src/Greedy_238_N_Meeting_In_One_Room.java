import java.util.Arrays;
import java.util.Comparator;

public class Greedy_238_N_Meeting_In_One_Room {
    // https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1#
    public static int maxMeetings(int[] start, int[] end, int n) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }

        Arrays.sort(arr, (a, b) -> {
            return a[1] - b[1];
        });
        int count = 1;
        int last = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] > last) {
                count++;
                last = arr[i][1];

            }
        }
        return count;

    }


}
