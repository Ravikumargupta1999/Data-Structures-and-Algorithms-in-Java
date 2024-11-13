package InterviewQuestion;

import java.util.ArrayList;

public class Video_91_Diagonal_Traverse {
    // https://leetcode.com/problems/diagonal-traverse/submissions/
    public int[] findDiagonalOrder(int[][] matrix) {
        int i = 0;
        int j = 0;
        int[] res = new int[matrix[0].length * matrix.length];
        boolean flag = true;
        int k = 0;
        while (j < matrix[0].length) {
            int row = i;
            int col = j;
            ArrayList<Integer> temp = new ArrayList<>();
            while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
                temp.add(matrix[row][col]);
                row++;
                col--;
            }
            k = copy(res,k,temp,flag);
            flag = !flag;
            j++;
        }

        j = matrix[0].length - 1;
        i = 1;
        while (i < matrix.length) {
            int row = i;
            int col = j;
            ArrayList<Integer> temp = new ArrayList<>();
            while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
                temp.add(matrix[row][col]);
                row++;
                col--;
            }
            k = copy(res,k,temp,flag);
            flag = !flag;
            i++;

        }
        return res;
    }

    public int copy(int[] res, int k, ArrayList<Integer> list, boolean flag) {
        if (!flag) {
            for (int val : list)
                res[k++] = val;
        } else {
            for (int i = list.size() - 1; i >= 0; i--)
                res[k++] = list.get(i);
        }
        return k;
    }
}
