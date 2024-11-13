package Biweekly_Contest_62;

public class Convert_1D_Array_Into_2D_Array {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n)
            return new int[][]{};
        int k = 0;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j=0;j<n;j++){
                arr[i][j] = original[k++];
            }
        }
        return arr;
    }
}
