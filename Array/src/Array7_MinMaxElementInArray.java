import java.util.Scanner;
//Done
public class Array7_MinMaxElementInArray {
//    https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1/

    //    Method 1
    public static void Min_max(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if (arr.length == 1) {
            min = max = arr[0];
        }
        if (arr.length > 1) {
            if (arr[0] < arr[1]) {            //1
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            for (int i = 2; i < arr.length; i++) {    //  2(n-2)
                if (arr[i] < min)
                    min = arr[i];
                else if (arr[i] > max)
                    max = arr[i];
            }
        }
    }

    //    Method 2
    class pair {
        long first, second;

        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public pair MinMax(long[] arr) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        int i;

        if (arr.length % 2 == 0)  // 1 Comparison
        {
            if (arr[0] < arr[1]) // 1 Comparison i.e. in case of even numbers
            {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i = 2;
        } else {
            min = arr[0];
            max = arr[0];
            i = 1;
        }

        for (int j = i; j < arr.length - 1; j = j + 2) {    //  3*((n-1))/2
            if (arr[j] > arr[j + 1]) {
                if (arr[j] > max)
                    max = arr[j];
                if (arr[j + 1] < min)
                    min = arr[j + 1];
            } else {
                if (arr[j] < min)
                    min = arr[j];
                if (arr[j + 1] > max)
                    max = arr[j + 1];
            }
        }
        return new pair(max, min);
    }

    //    / Method 3
    static class MinMaxPair {
        int min;
        int max;
    }

    public static MinMaxPair minMaxElement(int[] arr, int start, int end) {
        MinMaxPair pair = new MinMaxPair();
        MinMaxPair Pair1 = new MinMaxPair();
        MinMaxPair Pair2 = new MinMaxPair();
        int mid;

        if (start == end) {
            pair.max = arr[start];
            pair.min = arr[start];
            return pair;

        }

        if (start == end - 1) {
            if (arr[start] > arr[end]) {
                pair.min = arr[end];
                pair.max = arr[start];
            } else {
                pair.min = arr[start];
                pair.max = arr[end];
            }
            return pair;
        }

        mid = (start + end) / 2;
        Pair1 = minMaxElement(arr, start, mid);
        Pair2 = minMaxElement(arr, mid + 1, end);

        if (Pair1.min < Pair2.min)
            pair.min = Pair1.min;
        else
            pair.min = Pair2.min;

        if (Pair1.max < Pair2.max)
            pair.max = Pair2.max;
        else
            pair.max = Pair1.max;
        return pair;
    }
}
