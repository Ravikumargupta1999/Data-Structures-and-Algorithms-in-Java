public class Binary_Search {
    public static int binarySearch(int[] arr,int tar)
    {
        int s = 0;
        int e = arr.length-1;
        while (s<=e)
        {
            int mid = s + (e-s)/2;
            if(arr[mid] > tar)
                e = mid-1;
            else if (arr[mid] < tar)
                s = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,4,6,8,34,50,67,99,793};
        System.out.println(binarySearch(arr,794));
    }
}
