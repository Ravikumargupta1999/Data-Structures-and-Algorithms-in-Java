// https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1

import java.util.Arrays;

public class Search_in_a_matrix {
    public static int[] matSearch(int matrix[][], int N, int M, int target)
    {
        int r = 0;
        int c = M-1;
        while (r<N && c >=0)
        {
            if(matrix[r][c] == target)
                return new int[]{r,c};
            else if(matrix[r][c]>target)
                c--;
            else
                r++;
        }
        return new int[]{-1,-1};

    }
    public static void main(String[] args) {
        int[][] arr = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        System.out.println(Arrays.toString(matSearch(arr,arr.length,arr[0].length,75)));

    }
}
