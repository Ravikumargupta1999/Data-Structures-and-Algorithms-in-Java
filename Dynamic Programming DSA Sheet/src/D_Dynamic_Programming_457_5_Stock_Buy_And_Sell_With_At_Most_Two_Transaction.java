public class D_Dynamic_Programming_457_5_Stock_Buy_And_Sell_With_At_Most_Two_Transaction {
    // https://www.youtube.com/watch?v=wuzTpONbd-0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=34
    // https://practice.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    //  0  1  2  3   4   5   - i
    //  1  3  2  8   4   9   - arr[i]
    public static int stockBuySell(int[] arr, int n) {
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
        int[] dpr = new int[arr.length];// right dp
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
