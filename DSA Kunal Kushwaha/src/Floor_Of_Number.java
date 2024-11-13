public class Floor_Of_Number {
    public static int FloorNumber(int[] arr, int target) {
        if(arr[0] > target)
            return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid])
                end = mid - 1;

            else if (target > arr[mid])
                start = mid + 1;

            else
                return mid;
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 12, 45, 67, 78};
        System.out.println(arr.length);
        int target = 0;
        System.out.println(FloorNumber(arr, target));
    }
}
