import java.util.Arrays;
// https://www.geeksforgeeks.org/rotate-ring-matrix-anticlockwise-k-elements/
public class Shell_Rotate {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {
                        10, 11, 12, 5},
                {
                        9, 8, 7, 6
                }
        };
//        int[][] arr = {{1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}};

        for (
                int i = 0;
                i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < 10)
                    System.out.print(arr[i][j] + "   ");
                else
                    System.out.print(arr[i][j] + "  ");

            }
            System.out.print("\n");

        }
        System.out.print("\n\n");

        rotateShell(arr, 2);

        for (
                int i = 0;
                i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < 10)
                    System.out.print(arr[i][j] + "   ");
                else
                    System.out.print(arr[i][j] + "  ");
            }
            System.out.print("\n");

        }
        System.out.print("\n\n");

    }

    public static void rotateShell(int[][] arr, int r) {
        for (int s = 1; s <= arr.length / 2; s++) {
            int[] oned = fillOnedFromShell(arr, s);
            rotate(oned, r);
            fillShellFromOnes(arr, oned, s);
        }
    }

    static int[] fillOnedFromShell(int[][] arr, int s) {
        int minr = s - 1;
        int minc = s - 1;
        int maxc = arr[0].length - s;
        int maxr = arr.length - s;
        int size = 2 * (maxr - minr + maxc - minc);
        int[] oned = new int[size];
        System.out.println(size);
        int index = 0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            oned[index++] = arr[i][j];
        }
        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            oned[index++] = arr[i][j];
        }
        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            oned[index++] = arr[i][j];
        }
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
            oned[index++] = arr[i][j];
        }
        System.out.println(Arrays.toString(oned));
        return oned;
    }

    static void fillShellFromOnes(int[][] arr, int[] oned, int s) {
        int minr = s - 1;
        int minc = s - 1;
        int maxc = arr[0].length - s;
        int maxr = arr.length - s;
        int index = 0;
        for (int i = minr, j = minc; i <= maxr; i++) {
            arr[i][j] = oned[index++];
        }
        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            arr[i][j] = oned[index++];
        }
        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            arr[i][j] = oned[index++];
        }
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
            arr[i][j] = oned[index++];
        }
    }

    static void rotate(int[] arr, int k) {
        k = k % arr.length;
        if (k < 0)
            k = k + arr.length;
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }

    }

}
