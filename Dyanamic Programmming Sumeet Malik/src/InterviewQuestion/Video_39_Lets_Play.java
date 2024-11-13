package InterviewQuestion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Video_39_Lets_Play {
    // https://practice.geeksforgeeks.org/problems/lets-play0201/1
    static int isSuperSimilar(int n, int m, int mat[][], int x) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                int[] temp = new int[m];
                for (int j = 0; j < mat[0].length; j++) {
                    temp[j] = mat[i][j];
                }
                rotateArrLeft(temp, x, m);
                for (int j = 0; j < mat[0].length; j++) {
                    if (temp[j] != mat[i][j])
                        return 0;
                }
            } else {
                int[] temp = new int[m];
                for (int j = 0; j < mat[0].length; j++) {
                    temp[j] = mat[i][j];
                }
                rotateArrRight(temp, x, m);
                for (int j = 0; j < mat[0].length; j++) {
                    if (temp[j] != mat[i][j])
                        return 0;
                }
            }
        }
        return 1;
    }

    static void rotateArrLeft(int arr[], int d, int n)
    {
        d = d % n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    static void rotateArrRight(int arr[], int d, int n)
    {
        d = d % n;
        reverse(arr,0,n-d-1);
        reverse(arr,n-d,n-1);
        reverse(arr,0,n-1);
    }
    public static void reverse(int[] arr,int low,int high)
    {
        while (low <= high)
        {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
