public class Video_15_Find_Minimum_in_Rotated_Sorted_Array {
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] arr) {
        int l = 0;
        int h = arr.length-1;
        if( arr[l] <= arr[h])
            return arr[0];
        while (l <= h)
        {
            int mid = (l + h)/2;
            if(l + 1 ==  h)
            {
                if(arr[l] < arr[h])
                    return arr[l];
                else
                    return arr[h];
            }
            if(arr[mid] < arr[mid-1])
                return arr[mid];
            else if(arr[mid] > arr[mid + 1])
                return arr[mid + 1];
            else if(arr[l] <= arr[mid])
                l = mid +1;
            else if(arr[mid] <= arr[h])
                h = mid-1;
        }
        return -1;
    }
}
