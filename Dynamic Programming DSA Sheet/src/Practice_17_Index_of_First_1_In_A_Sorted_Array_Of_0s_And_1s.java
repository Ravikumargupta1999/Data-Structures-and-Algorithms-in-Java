public class Practice_17_Index_of_First_1_In_A_Sorted_Array_Of_0s_And_1s {
    public static long firstIndex(long[] arr, long n) {
        // Your code goes here
        long res = -1;
        long s = 0;
        long e = n - 1;

        while (s <= e) {
            long m = (s + e) / 2;

            if (arr[(int) m] == 1) {
                res = m;
                e = m - 1;
            } else
                s = m + 1;

        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(firstIndex(arr,arr.length));
    }
}
