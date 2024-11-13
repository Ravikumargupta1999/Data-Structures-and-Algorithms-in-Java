public class OrderAgnosticBinarySearch {
    public static int binarySearch(int[] arr, int tar) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > tar)
                s = mid + 1;
            else if (arr[mid] < tar)
                e = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {793, 56, 23, 20, 17, 15, 11, 9, 6, 3, 0, -98};
        System.out.println(binarySearch(arr, -99));
    }
}
