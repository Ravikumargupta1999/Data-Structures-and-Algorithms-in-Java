package Two;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/find-the-largest-rectangle-of-1s-with-swapping-of-columns-allowed0243/1
// https://www.youtube.com/watch?v=fGKRnCL3CqA
public class Largest_Rectangle_Of_1s {
    static int maxArea(boolean[][] mat, int r, int c) {

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = mat[i][j] ? 1 : 0;
            }
        }

//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(arr[i][j] + "  ");
//            }
//            System.out.println("");
//        }


        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0)
                    temp[i][j] = arr[i][j];
                else
                    temp[i][j] = arr[i][j] == 0 ? 0 : temp[i - 1][j] + arr[i][j];
            }
        }
//        System.out.println("");
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(temp[i][j] + "  ");
//            }
//            System.out.println("");
//        }


        int ans = 0;
        for (int i = 0; i < r; i++) {
            int[] array = temp[i];
            Arrays.sort(array);
            reverseArray(array);
            for (int j = 0; j < c; j++) {
                ans = Math.max(ans, (j + 1) * array[j]);
            }
        }
        return ans;
    }

    public static void reverseArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        boolean[][] mat = {{false, true, false, true, false},
                {false, true, false, true, true},
                {true, true, false, true, false}};
        System.out.println(maxArea(mat, mat.length, mat[0].length));
    }
}
