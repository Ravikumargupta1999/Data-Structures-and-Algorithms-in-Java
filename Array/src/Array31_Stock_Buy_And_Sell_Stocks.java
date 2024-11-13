import java.util.ArrayList;

public class Array31_Stock_Buy_And_Sell_Stocks {
    // https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1#
    ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int buyingDay = 0;
        int sellingDay = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1])
                sellingDay++;
            else {
                if (buyingDay != sellingDay) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(buyingDay);
                    temp.add(sellingDay);
                    arrayList.add(temp);
                }
                buyingDay = i;
                sellingDay = i;
            }
        }
        if (buyingDay != sellingDay) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(buyingDay);
            temp.add(sellingDay);
            arrayList.add(temp);
        }
        return arrayList;
    }

    public void stockBuySell1(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int buyingDay = 0;
        int sellingDay = 0;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1])
                sellingDay++;
            else {
                if (buyingDay != sellingDay) {
                    System.out.println("(" + buyingDay + " " + sellingDay + ")");
                    flag = true;
                }
                buyingDay = i;
                sellingDay = i;
            }
        }
        if (buyingDay != sellingDay) {
            System.out.println("(" + buyingDay + " " + sellingDay + ")");
            flag = true;
        }
        if(!flag){
            System.out.println("No Profit");
        }

    }
}
