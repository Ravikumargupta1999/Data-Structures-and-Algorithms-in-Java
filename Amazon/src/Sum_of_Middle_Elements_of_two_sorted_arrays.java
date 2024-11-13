import java.util.Arrays;


// https://practice.geeksforgeeks.org/problems/sum-of-middle-elements-of-two-sorted-arrays2305/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&query=category[]Arrayscompany[]Amazondifficulty[]1page2company[]Amazoncategory[]Arrays#

public class Sum_of_Middle_Elements_of_two_sorted_arrays {
    int findMidSum(int[] arr1, int[] arr2, int n) {


        int i= n-1;
        int j=0;
        while(i>=0 && j<n)
        {
            if(arr1[i]>=arr2[j])
            {
                int temp = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = temp;
                i--;
                j++;
            }
            else
                break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return arr1[arr1.length-1] + arr2[0];
    }
}
