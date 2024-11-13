import java.util.Arrays;

public class Recursive_Insertion_Sort {
    public static int[] insertionSort(int[] arr)
    {
        insertion(arr,0);
        return arr;
    }
    public static void insertion(int[] arr,int index)
    {
        if(index == arr.length)
            return;
        int j = index;
        while (j>=1)
        {
            if(arr[j] > arr[j-1])
                break;
            else
            {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        insertion(arr,index+1);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{61, 34, 25, 12, 22, 11, 90})));
    }
}
