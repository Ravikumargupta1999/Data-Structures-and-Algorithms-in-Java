package Day_2_Arrays;

import java.util.ArrayList;

public class Count_Inversions_GFG {

    // https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
    static long inversionCount(long arr[], long n)
    {
        ArrayList<Long> res = new ArrayList<>();
        res.add((long) 0);
        mergeSort_(arr, 0, n - 1, res);
        return res.get(0);
    }

    public static long[] mergeSort_(long[] arr, long start, long end, ArrayList<Long> list) {
        if (start == end) {
            return new long[]{arr[(int) start]};
        } else {
            long mid = (start + end) / 2;
            long[] left = mergeSort_(arr, start, mid, list);
            long[] right = mergeSort_(arr, mid + 1, end, list);
            long[] mergeArray = merge(arr, left, right, start, list);
            return mergeArray;
        }

    }

    public static long[] merge(long[] arr, long[] left, long[] right, long st, ArrayList<Long> list) {

        long[] temp = new long[left.length + right.length];
        long k = 0;
        long i = 0;
        long j = 0;
        while (i < left.length && j < right.length) {
            if (left[(int)i] <= right[(int)j]) {
                temp[(int)k++] = left[(int) i++];
            } else {
                list.set(0, list.get(0) + (left.length - i));
                temp[(int)k++] = right[(int)j++];
            }
        }
        while (i < left.length) {
            temp[(int)k++] = left[(int)i++];
        }
        while (j < right.length) {
            temp[(int)k++] = right[(int)j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[(int)st++] = temp[(int)i];
        }
        return temp;

    }
}
