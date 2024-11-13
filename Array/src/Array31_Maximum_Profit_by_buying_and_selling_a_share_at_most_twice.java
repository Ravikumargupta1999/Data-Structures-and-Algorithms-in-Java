import java.util.Scanner;

public class Array31_Maximum_Profit_by_buying_and_selling_a_share_at_most_twice {
    public static int stockBuySell(int[] arr,int n) {
        int mp_ist = 0; //mp_ist --> Maximum profit if sold it today
        int least_sf = arr[0];// least_sf --> least so far
        int[] dpl = new  int[arr.length];// left dp
        for(int i=1;i< arr.length;i++)
        {
            if(arr[i]<least_sf)
                least_sf = arr[i];
            mp_ist = arr[i] - least_sf;
            if(mp_ist>dpl[i-1])
                dpl[i]= mp_ist;
            else
                dpl[i] = dpl[i-1];
        }

        int mp_ibt = 0; //mp_ibt --> Maximum profit if buy it today
        int max_sf = arr[arr.length-1];// max_sf --> least so far
        int[] dpr = new  int[arr.length];// left dp
        for(int i=arr.length-2;i>=0;i--)
        {
            if(arr[i]>max_sf)
                max_sf= arr[i];
            mp_ibt = max_sf-arr[i];
            if(mp_ibt>dpr[i+1])
                dpr[i]= mp_ibt;
            else
                dpr[i] = dpr[i+1];
        }
        int op=0;
        for(int i=0;i<arr.length;i++)
        {
            if(dpl[i]+dpr[i]>op)
                op = dpl[i]+dpr[i];
        }
        return op;

    }
}
// { 2, 30, 15, 10, 8, 25, 80 };
// https://www.youtube.com/watch?v=wuzTpONbd-0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=34
// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//Input:   price[] = {10, 22, 5, 75, 65, 80}
//        Output:  87
//        Trader earns 87 as sum of 12, 75
//        Buy at 10, sell at 22,
//        Buy at 5 and sell at 80
//
//        Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
//        Output:  100
//        Trader earns 100 as sum of 28 and 72
//        Buy at price 2, sell at 30, buy at 8 and sell at 80
//
//        Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
//        Output:  72
//        Buy at price 8 and sell at 80.
//
//        Input:   price[] = {90, 80, 70, 60, 50}
//        Output:  0
//        Not possible to earn.