package Recursion;

public class Recursion_12_First_Occurrence_Of_An_Element {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,2,3,4,6};
        System.out.println(findFirstOccurrence(arr,0,6));
    }
    public static int findFirstOccurrence(int[] arr, int idx, int val)
    {
        if(idx == arr.length-1 )
        {
            if( arr[idx] == val)
                return idx;
            return -1;
        }
        if( arr[idx] == val)
            return idx;
        return findFirstOccurrence(arr,idx+1,val);
    }
}
