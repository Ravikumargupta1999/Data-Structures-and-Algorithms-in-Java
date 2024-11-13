package Biweekly_Contest_64;

import java.util.Arrays;

public class Two_Best_Non_Overlapping_Events {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            return a[1] - b[1];
        });
        int res = 0;
        for (int i = 0; i < events.length; i++) {
            for (int j = i + 1; j < events.length; j++) {
                if (events[j][0] > events[i][2])
                    res = Math.max(res, events[i][2] + events[j][2]);

            }
        }
        return res;
    }
}
