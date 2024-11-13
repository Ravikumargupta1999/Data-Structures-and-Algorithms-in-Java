public class First_And_Last_Index {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 7, 123, 125};
        arr = firstAndLastIndex(arr, 7);
        System.out.println(arr[0] + "   " + arr[1]);
    }

    static int[] firstAndLastIndex(int[] arr, int x) {
        int[] res = new int[2];
        res[0] = binarySearch(arr, x, false);
        res[1] = binarySearch(arr, x, true);
        return res;
    }

    public static int binarySearch(int[] arr, int x, boolean found) {
        int start = 0;
        int end = arr.length - 1;
        int value = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (x < arr[mid]) {
                end = mid - 1;
            } else if (x > arr[mid]) {
                start = mid + 1;
            } else {
                value = mid;
                if (found)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

        }
        return value;
    }
}
