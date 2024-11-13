import java.util.ArrayList;
import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=4&query=company[]Amazondifficulty[]0page4company[]Amazon#

public class Counting_elements_in_two_arrays_Efficient_Approach {
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
        Arrays.sort(arr2);
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n - 1;
            while (low <= high) {

                int mid = (low + high) / 2;

                if (arr2[mid] <= arr1[i])
                    low = mid + 1;

                else
                    high = mid - 1;
            }
            al.add(high+1);
        }
        return al;
    }

    public static void main(String[] args) {
        int arr1[] = {4, 8, 7, 5, 1};
        int arr2[] = {4, 48, 3, 0, 1, 1, 5};
        System.out.println(countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length));
    }
}
