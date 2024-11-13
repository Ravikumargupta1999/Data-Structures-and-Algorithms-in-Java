public class Ceiling_Of_Number {
    public static int ceilingNumber(int[] arr, int target) {
        if(arr[arr.length-1] < target)
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
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 12, 45, 67, 78};
        System.out.println(arr.length);
        int target = 79;
        System.out.println(ceilingNumber(arr, target));
    }
}
