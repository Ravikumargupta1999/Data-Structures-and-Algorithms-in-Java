package Time_And_Space_Complexity;

public class Sort01 {
    public static void main(String[] args) {

    }
    // https://practice.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1#
    static void binSort(int[] arr, int N)
    {
        int i = 0;
        int j = 0;
        while (i < arr.length)
        {
            if(arr[i] == 1)
            {
                i++;
            }
            else
            {
                swap(i,j,arr);
                i++;
                j++;
            }
        }
    }
    public static void swap(int i,int j,int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
