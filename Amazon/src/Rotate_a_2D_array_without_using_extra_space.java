public class Rotate_a_2D_array_without_using_extra_space {
    void rotateMatrix(int matrix[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[left][i];
                matrix[left][i] = matrix[right][i];
                matrix[right][i] = temp;
                left++;
                right--;
            }
        }
    }

    void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + "  ");
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Rotate_a_2D_array_without_using_extra_space a = new Rotate_a_2D_array_without_using_extra_space();
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println("Before Rotation : ");
        a.printMatrix(arr);

        a.rotateMatrix(arr, arr.length);
        System.out.println("\n\nAfter Rotation : ");
        a.printMatrix(arr);

    }
}
