public class Wave_Traversal {
    public static void main(String[] args) {
        int arr1[][] = {{1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4}};
        waveTraversal(arr1);
    }

    public static void waveTraversal(int[][] arr) {
        boolean down = true;
        for (int i = 0; i < arr[0].length; i++) {
            if (down) {
                for (int j = 0; j < arr.length; j++)
                    System.out.print(arr[j][i] + "  ");
                System.out.print("\n");
                down = false;
            } else {
                for (int j = arr.length - 1; j >= 0; j--)
                    System.out.print(arr[j][i] + "  ");
                System.out.print("\n");
                down = true;
            }
        }
    }
}
