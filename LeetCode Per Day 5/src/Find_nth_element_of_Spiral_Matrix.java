public class Find_nth_element_of_Spiral_Matrix {
    int findK(int A[][], int n, int m, int k) {
        int minRow = 0;
        int maxRow = n - 1;
        int minCol = 0;
        int maxCol = m - 1;
        int count = 0;

        while (count < n * m) {

            for (int i = minRow, j = minCol; j < maxCol; j++) {
                count++;
                if (count == k)
                    return A[i][j];
            }
            minRow++;

            for (int i = minRow, j = maxCol; i <= maxRow; i++) {
                count++;
                if (count == k)
                    return A[i][j];
            }
            maxCol--;

            for (int i = maxRow, j = maxCol; j >= minCol; j--) {
                count++;
                if (count == k)
                    return A[i][j];
            }
            minRow--;

            for (int i = maxRow, j = minCol; i >= minRow; i--) {
                count++;
                if(count == k)
                    return A[i][j];
            }
            maxCol++;

        }
        return -1;
    }
}
