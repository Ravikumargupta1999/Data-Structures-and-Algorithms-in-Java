package Day_2_Arrays;

import java.util.ArrayList;

public class Count_Inversion {
    public static void main(String[] args) {
        long[] arr = {2, 5, 1, 3, 4};
        System.out.println(getInversions(arr, arr.length));
    }

    public static long getInversions(long[] arr, int n) {
        ArrayList<Long> res = new ArrayList<>();
        res.add((long) 0);
        mergeSort_(arr, 0, n - 1, res);
        return res.get(0);
    }

    public static long[] mergeSort_(long[] arr, int start, int end, ArrayList<Long> list) {
        if (start == end) {
            return new long[]{arr[start]};
        } else {
            int mid = (start + end) / 2;
            long[] left = mergeSort_(arr, start, mid, list);
            long[] right = mergeSort_(arr, mid + 1, end, list);
            long[] mergeArray = merge(arr, left, right, start, list);
            return mergeArray;
        }

    }

    public static long[] merge(long[] arr, long[] left, long[] right, int st, ArrayList<Long> list) {

        long[] temp = new long[left.length + right.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                temp[k++] = left[(int) i++];
            } else {
                list.set(0,list.get(0) + (left.length-i));
                temp[k++] = right[j++];
            }
        }
        while (i < left.length) {
            temp[k++] = left[i++];
        }
        while (j < right.length) {
            temp[k++] = right[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[st++] = temp[i];
        }
        return temp;
    }
}
