import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Searching_Sorting_127_Maximum_Profit_In_Job_Scheduling {
    public  class Scheduling {
        int start;
        int end;
        int profit;

        public Scheduling(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] starTime, int[] endTime, int[] profit) {
        ArrayList<Scheduling> array = new ArrayList<Scheduling>();
        for (int i = 0; i < starTime.length; i++) {
            array.add(new Scheduling(starTime[i], endTime[i], profit[i]));
        }
        Collections.sort(array, new Comparator<Scheduling>() {
                    @Override
                    public int compare(Scheduling o1, Scheduling o2) {
                        Integer i1 = (Integer) o1.end;
                        Integer i2 = (Integer) o2.end;
                        return i1.compareTo(i2);
                    }
                }
        );

        int[] dp = new int[starTime.length];
        dp[0] = array.get(0).profit;
        for (int i = 1; i < starTime.length; i++) {
            int inc = array.get(i).profit;
            int last = -1;
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (array.get(mid).end <= array.get(i).start) {
                    last = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (last != -1) {
                inc += dp[last];
            }
            int exc = dp[i - 1];
            dp[i] = Math.max(inc, exc);

        }
        return dp[starTime.length - 1];
    }
}
