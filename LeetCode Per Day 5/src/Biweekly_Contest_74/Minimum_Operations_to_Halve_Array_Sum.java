package Biweekly_Contest_74;

import java.util.PriorityQueue;

public class Minimum_Operations_to_Halve_Array_Sum {
    public static void main(String[] args) {
        int[] arr = {5, 19, 8, 1};
        System.out.println(halveArray(arr));
    }

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> {
            return b > a ? 1 : -1;
        });
        double totalSum = 0;
        for (int num : nums) {
            totalSum += (double) num;
            queue.add((double) num);
        }
        // System.out.println("Total Sum : " + totalSum);
        double d = 0;
        int count = 0;
        // System.out.println("Total Sum : " + totalSum + "    d : " + d);
        while (!queue.isEmpty() && (totalSum - d) >= totalSum / 2) {
            double temp = queue.poll();
            System.out.println(temp);
            d = d + temp / 2;
            // System.out.println("Total Sum : " + totalSum + "    d : " + d + "      temp : " + temp);
            queue.add(temp / 2);
            count++;
            if ((totalSum - d) <= totalSum / 2) {
                // System.out.println("(totalSum-d)  : " + (totalSum - d));
                return count;
            }
        }
        return count;
    }
}
