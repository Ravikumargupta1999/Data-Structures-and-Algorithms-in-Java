import java.util.Arrays;
import java.util.Comparator;

public class Greedy_242_Fractional_Knapsack {

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    // https://www.youtube.com/watch?v=F_DDzYnxO14
    // https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1#
    static double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, (a, b) -> {
            // Wrong sorting
            // double d1 = (double) (a.value/a.weight);
            // double d2 = (double) (b.value/b.weight);
            double d1 = ((double) a.value / (double) a.weight);
            double d2 = ((double) b.value / (double) b.weight);
            if (d1 < d2)
                return 1;
            else if (d1 > d2)
                return -1;
            else
                return 0;
        });

        int currentWeight = 0;
        double profit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currentWeight + arr[i].weight <= W) {
                currentWeight += arr[i].weight;
                profit += arr[i].value;
            } else {
                int left = W - currentWeight;
                double d = ((double) arr[i].value / (double) arr[i].weight) * ((double) left);
                profit += d;
                currentWeight += left;
                break;
            }
        }
        return profit;

    }


    public static void main(String[] args) {
        int n = 3;
        int w = 50;
        Item[] arr = new Item[n];
        arr[0] = new Item(60, 10);
        arr[1] = new Item(100, 20);
        arr[2] = new Item(120, 30);
        System.out.println(fractionalKnapsack(w, arr, n));


    }
}
//N = 3, W = 50
//        values[] = {60,100,120}
//        weight[] = {10,20,30}