public class Addition_of_submatrix {
    long subMatrixSum(int arr[][], int n, int m, int x1, int y1, int x2, int y2) {
        // code here
        long res = 0;
        for (int i = x1 - 1; i < x2; i++) {
            for (int j = y1 - 1; j < y2; j++) {
               res += arr[i][j];
            }
        }
        return res;
    }
}
