public class Binary_Search_Recursion {
    public static int binarySearch(int[] arr,int start,int end , int val)
    {
//        if( start <= end)
//            System.out.println(start+" "+end + "   "+(start + (end - start) /2));
//        else
//            System.out.println(start+" "+end + "   start is greater than end so returning");
        if(start > end)
            return -1;
        int mid = start + (end - start) /2;
        if(arr[mid] == val)
            return mid;
        else if(arr[mid] < val)
            return binarySearch(arr,mid+1,end,val);
        else
            return binarySearch(arr,start,mid-1,val);
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,3,4,5,6,8,9,10},0,7,7));
    }
}
