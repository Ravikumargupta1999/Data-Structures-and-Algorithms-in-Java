public class First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] arr, int target) {
        int[] ans = {-1, -1};
        int start = search(arr, target, true);
        int end = search(arr, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    public int search(int[] arr, int target, boolean firstIndex) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target)
                start = mid + 1;
            else if (arr[mid] > target)
                end = mid - 1;
            else {
                ans = mid;
                if (firstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {

    }
}
