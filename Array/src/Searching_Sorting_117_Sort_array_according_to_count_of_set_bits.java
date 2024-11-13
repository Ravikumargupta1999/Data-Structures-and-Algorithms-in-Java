import java.util.Arrays;

public class Searching_Sorting_117_Sort_array_according_to_count_of_set_bits {
    // https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1#
    static void sortBySetBitCount(Integer[] arr, int n) {
        Arrays.sort(arr, (a, b) -> {
            return setBits(a) - setBits(b);
        });
    }

    static int setBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;

    }
}
