public class Array31_Best_Time_To_Buy_And_Sell_Stocks_5_Two_Transaction_Allowed {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    // https://www.youtube.com/watch?v=wuzTpONbd-0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=35
    // https://practice.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1/
    public int maxProfit(int[] arr) {
        int mp_ist = 0; //mp_ist --> Maximum profit if sold it today
        int least_sf = arr[0];// least_sf --> least so far
        int[] dpl = new int[arr.length];// left dp
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < least_sf)
                least_sf = arr[i];
            mp_ist = arr[i] - least_sf;
            if (mp_ist > dpl[i - 1])
                dpl[i] = mp_ist;
            else
                dpl[i] = dpl[i - 1];
        }

        int mp_ibt = 0; //mp_ibt --> Maximum profit if buy it today
        int max_sf = arr[arr.length - 1];// max_sf --> least so far
        int[] dpr = new int[arr.length];// left dp
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max_sf)
                max_sf = arr[i];
            mp_ibt = max_sf - arr[i];
            if (mp_ibt > dpr[i + 1])
                dpr[i] = mp_ibt;
            else
                dpr[i] = dpr[i + 1];
        }
        int op = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dpl[i] + dpr[i] > op)
                op = dpl[i] + dpr[i];
        }
        return op;
    }
}
