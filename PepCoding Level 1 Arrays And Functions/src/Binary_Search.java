public class Binary_Search {
    public static void main(String[] args) {
        int[] arr = {10, 23, 42, 53, 67, 69, 70};
        System.out.println(binarySearch(arr, 6));
    }

    static int binarySearch(int[] arr, int x) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (arr[m] == x)
                return i;
            else if (x < arr[m])
                j = m - 1;
            else
                i = m + 1;
        }
        return -1;
    }
}
