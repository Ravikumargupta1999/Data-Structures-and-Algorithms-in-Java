import java.util.ArrayList;

public class Rotation_Count {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Rotation_Count a = new Rotation_Count();
        System.out.println(a.findKRotation(arr,arr.length));
    }
    int findKRotation(int arr[], int n) {
       int pivot = findPivot(arr);
//       System.out.println(pivot);
//       if(pivot == -1)
//           return 0;
       return pivot+1;

    }
    int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
