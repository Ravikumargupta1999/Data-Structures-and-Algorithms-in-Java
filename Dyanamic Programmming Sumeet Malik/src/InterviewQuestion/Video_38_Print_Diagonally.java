package InterviewQuestion;

import java.util.ArrayList;

public class Video_38_Print_Diagonally {
    // https://practice.geeksforgeeks.org/problems/print-diagonally4331/1
    static ArrayList<Integer> downwardDigonal(int n, int A[][])
    {
        ArrayList<Integer> res = new ArrayList<>();
        int temp = n;
        int i = 0;
        int j = 0;
        while (temp-- > 0) {
            print(i, j, A, res);
            j++;
        }

        temp = n - 1;
        i = 1;
        j = n - 1;
        while (temp-- > 0) {
            print(i, j, A, res);
            i++;
        }
        return res;
    }

    static void print(int row, int col, int[][] matrix, ArrayList<Integer> res) {
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            res.add(matrix[row][col]);
            row++;
            col--;
        }
    }
}
