import java.util.Arrays;

public class Video_53_Minimum_Cost_For_Tickets {

    // recursion
//    int mincostTickets(int[] days, int[] costs) {
//        return recursion(days[0], costs, days);
//    }
//
//    int recursion(int currentDay, int[] cost, int[] days) {
//        if (currentDay > days[days.length - 1])
//            return 0;
//        if (willTravelToday(currentDay, days)) {
//            int today = recursion(currentDay + 1, cost, days) + cost[0];
//            int week = recursion(currentDay + 7, cost, days) + cost[1];
//            int month = recursion(currentDay + 30, cost, days) + cost[2];
//            return Math.min(today, Math.min(week, month));
//        } else
//            return recursion(currentDay + 1, cost, days);
//    }
//    public boolean willTravelToday(int cday, int[] days) {
//        for (int i = 0; i < days.length; i++) {
//            if (days[i] == cday) {
//                return true;
//            }
//        }
//        return false;
//    }


    // Memoization
//    int mincostTickets(int[] days, int[] costs) {
//        int[] dp = new int[400];
//        Arrays.fill(dp, -1);
//        return recursion(days[0], costs, days, dp);
//    }
//
//    int recursion(int currentDay, int[] cost, int[] days, int[] dp) {
//        if (currentDay > days[days.length - 1])
//            return 0;
//        if (dp[currentDay] != -1)
//            return dp[currentDay];
//        if (willTravelToday(currentDay, days)) {
//            int today = recursion(currentDay + 1, cost, days, dp) + cost[0];
//            int week = recursion(currentDay + 7, cost, days, dp) + cost[1];
//            int month = recursion(currentDay + 30, cost, days, dp) + cost[2];
//            return dp[currentDay] = Math.min(today, Math.min(week, month));
//        } else
//            return dp[currentDay] = recursion(currentDay + 1, cost, days, dp);
//    }
//
//    public boolean willTravelToday(int currentDay, int[] days) {
//        for (int i = 0; i < days.length; i++) {
//            if (days[i] == currentDay) {
//                return true;
//            }
//        }
//        return false;
//    }
    // https://leetcode.com/problems/minimum-cost-for-tickets/
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[400];
        for (int cday = 399; cday >= 0; cday--) {
            if (cday > days[days.length - 1]) {
                dp[cday] = 0;
                continue;
            }
            int ans = (int) 1e8;
            if (willTravelToday(cday, days)) {
                ans = dp[cday + 1] + costs[0];
                ans = Math.min(ans, dp[cday + 7] + costs[1]);
                ans = Math.min(ans, dp[cday + 30] + costs[2]);
                dp[cday] = ans;
            } else {
                dp[cday] = dp[cday + 1];
            }
        }
        return dp[1];
    }

    public boolean willTravelToday(int cday, int[] days) {
        for (int i = 0; i < days.length; i++) {
            if (days[i] == cday) {
                return true;
            }
        }
        return false;
    }
}
