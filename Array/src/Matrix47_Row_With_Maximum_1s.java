

// Done

public class Matrix47_Row_With_Maximum_1s {
    // https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
    public static int MaximumOnes(int[][] arr) {
        int row = arr.length - 1;
        int col = arr[0].length - 1;
        for (int i = 0; i <= col; i++) {
            for (int j = 0; j <= row; j++) {
                if (arr[j][i] == 1)
                    return j;
            }
        }
        return -1;
    }
}
