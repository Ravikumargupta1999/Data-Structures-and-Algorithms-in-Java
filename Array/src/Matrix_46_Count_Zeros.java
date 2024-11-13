public class Matrix_46_Count_Zeros {
    // https://practice.geeksforgeeks.org/problems/count-zeros-in-a-sorted-matrix/1

    // // https://www.youtube.com/watch?v=1jI6plttG0o
    public static int CountZero1(int[][] arr, int n) {
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < n && j >= 0) {
            // 1 hai to peeche chale jao
            if (arr[i][j] == 1) {
                j--;
            }
            // agar 1 nahi hai to count karke neeche chale jao
            else {
                count += (j + 1);
                i++;
            }
        }
        return count;
    }

    // https://www.youtube.com/watch?v=1jI6plttG0o
    int countZero2(int arr[][], int N) {
        int row = N - 1, col = 0;
        int count = 0;
        while (col < N) {
            while (arr[row][col] > 0)
                if (--row < 0)
                    return count;
            count += (row + 1);
            col++;
        }
        return count;
    }


}
