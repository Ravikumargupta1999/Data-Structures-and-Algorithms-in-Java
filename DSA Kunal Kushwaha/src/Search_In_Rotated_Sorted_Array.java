import java.util.ArrayList;

public class Search_In_Rotated_Sorted_Array {
    public static int findInMountainArray(int target, ArrayList<Integer> mountainArr) {
        System.out.println(mountainArr);
        int peak = peakIndexInMountainArray(mountainArr);
        System.out.println(peak);
        int val = binarySearch(mountainArr,target,0,peak);
        if(val != -1)
            return val;
        System.out.println("Hello");
        return orderOgnosticBinarySearch(mountainArr,target,peak+1,mountainArr.size()-1);


    }
    public static int peakIndexInMountainArray(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > arr.get(mid+1)) {
                end = mid;
            } else {

                start = mid + 1;
            }
        }
        return start;
    }
    public static int binarySearch(ArrayList<Integer> arr,int tar,int start,int end)
    {

        while (start<=end)
        {
            int mid = start + (end-start)/2;
            if(arr.get(mid) > tar)
                end = mid-1;
            else if (arr.get(mid) < tar)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    public static int orderOgnosticBinarySearch(ArrayList<Integer> arr, int tar,int start,int end) {
        int s = 0;
        int e = arr.size() - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr.get(mid) > tar)
                s = mid + 1;
            else if (arr.get(mid) < tar)
                e = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] arr = {0,1,2,4,2,1};
        for(int i=0;i<arr.length;i++)
        {
            al.add(arr[i]);
        }
        System.out.println(findInMountainArray(0,al));
    }
}
