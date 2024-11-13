public class Video_16_Rotation_Count {
    // https://practice.geeksforgeeks.org/problems/rotation4723/1
    int findKRotation(int arr[], int n) {
        int l = 0;
        int h = arr.length - 1;
        if (arr[l] <= arr[h])
            return 0;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (l + 1 == h) {
                if (arr[l] < arr[h])
                    return l;
                else
                    return h;
            }
            if (arr[mid] < arr[mid - 1])
                return mid;
            else if (arr[mid] > arr[mid + 1])
                return mid + 1;
            else if (arr[l] <= arr[mid])
                l = mid + 1;
            else if (arr[mid] <= arr[h])
                h = mid - 1;
        }
        return -1;
    }
}
