public class Floor_in_a_Sorted_Array {
    public static int floorOfArray(int[] arr,int n,int x)
    {

        int low = 0;
        int high = n-1;
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] == x)
            {
                high = mid;
                System.out.println("Mid : "+mid);
                break;
            }
            else if(arr[mid] < x)
            {
                low = mid + 1;
            }
            else
            {
                high = mid-1;
            }
        }

        System.out.println("High = "+high);
        return high;
    }
    public static void main(String[] args) {
        int n = 7, x = 0;
        int arr[] = {1, 2, 8, 10, 11, 12, 19};
        System.out.println(floorOfArray(arr,n,x));
    }
}
