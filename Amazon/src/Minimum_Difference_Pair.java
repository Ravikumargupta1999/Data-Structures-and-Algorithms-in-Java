import java.lang.reflect.Array;
import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/minimum-difference-pair5444/1/?company[]=Amazon&company[]=Amazon&page=2&query=company[]Amazonpage2company[]Amazon

public class Minimum_Difference_Pair {
    public int minimum_difference(int[] arr)
    {
        Arrays.sort(arr);
        int i=0;
        int j = 1;
        int min = arr[arr.length-1] - arr[0];
        while (j < arr.length)
        {
            if(arr[j]-arr[i] < min)
            {
                min = arr[j]-arr[i];
                i++;
                j++;
            }
            else
            {
                i++;
                j++;

            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
