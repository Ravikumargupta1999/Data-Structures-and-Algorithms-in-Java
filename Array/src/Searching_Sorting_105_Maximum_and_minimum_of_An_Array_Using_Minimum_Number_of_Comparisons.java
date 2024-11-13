public class Searching_Sorting_105_Maximum_and_minimum_of_An_Array_Using_Minimum_Number_of_Comparisons {
    static class pair {
        long first, second;
        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
    // https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1/
    static pair getMinMax(long[] arr, long n) {
        return MinMax(arr,0,n-1);
    }

    public static pair MinMax(long[] arr, long start, long end) {
        pair currPair = new pair(Integer.MAX_VALUE,Integer.MIN_VALUE);
        long mid;

        if (start == end) {
            currPair.first = arr[(int) start];
            currPair.second = arr[(int) start];
            return currPair;

        }

        if (start == end - 1) {
            if (arr[(int) start] > arr[(int) end]) {
                currPair.first= arr[(int) end];
                currPair.second = arr[(int) start];
            } else {
                currPair.first = arr[(int) start];
                currPair.second = arr[(int) end];
            }
            return currPair;
        }

        mid = (start + end) / 2;
        pair Pair1 = MinMax(arr, start, mid);
        pair Pair2 = MinMax(arr, mid + 1, end);

        if (Pair1.first < Pair2.first)
            currPair.first = Pair1.first;
        else
            currPair.first = Pair2.first;

        if (Pair1.second < Pair2.second)
            currPair.second = Pair2.second;
        else
            currPair.second = Pair1.second;
        return currPair;
    }
}
