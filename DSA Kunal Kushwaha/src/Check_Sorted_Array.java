public class Check_Sorted_Array {
    //https://practice.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1
    boolean check(int[] arr,int ind)
    {
        if(arr.length == 1)
            return true;
        if(ind == arr.length-1)
            return true;
        if(arr[ind] > arr[ind+1])
            return false;
        return check(arr,ind+1);

    }

    public static void main(String[] args) {
        Check_Sorted_Array a = new Check_Sorted_Array();
        System.out.println(a.check(new int[]{1,4},0));
    }
}
