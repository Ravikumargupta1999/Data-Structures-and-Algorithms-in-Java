import java.util.ArrayList;

public class Array22_Stock_buy_and_sell_One_Transaction_GFG {
    // https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1#
    ArrayList<ArrayList<Integer>> stockBuySell(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        if (n == 1)
            return al;
        if (n == 2) {
            if (arr[1] > arr[0]) {
                ArrayList<Integer> al1 = new ArrayList<>();
                al1.add(0);
                al1.add(1);
                al.add(al1);

            }
            return al;
        }
        int bd = 0;
        int sd = 0;
        int profit = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                sd++;
            } else {
                ArrayList<Integer> al1 = new ArrayList<>();
                if (arr[bd] < arr[sd]) {
                    al1.add(bd);
                    al1.add(sd);
                    al.add(al1);
                    // bd = sd = i;
                }
                bd = sd = i;
            }

        }

        if (sd != bd) {
            ArrayList<Integer> al1 = new ArrayList<>();
            al1.add(bd);
            al1.add(sd);
            al.add(al1);
        }

        return al;
    }
}
