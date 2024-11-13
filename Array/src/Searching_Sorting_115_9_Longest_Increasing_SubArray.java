
public class Searching_Sorting_115_9_Longest_Increasing_SubArray {

    // https://practice.geeksforgeeks.org/problems/longest-increasing-subarray3811/1
    public long lenOfLongIncSubArr(long arr[], long n) {
        long max = 1;
        long len = 1;
        for (long i = 1; i < arr.length; i++) {
            if (arr[(int) i] > arr[(int) i - 1])
                len++;
            else {
                if (max < len)
                    max = len;
                len = 1;
            }
        }
        if (max < len)
            max = len;
        return max;
    }

    public static void main(String[] args) {

    }
}
