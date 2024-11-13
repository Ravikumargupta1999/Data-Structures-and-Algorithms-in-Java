package Day_8_Greeedy_Algorithm;

import java.util.Arrays;

public class Fractional_Knapsack {
    class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    double fractionalKnapsack(int W, Item[] arr, int n) {
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
}
