public class Matrix_Multiplication {
    // // https://practice.geeksforgeeks.org/problems/multiply-matrices/1
    //    // https://www.youtube.com/watch?v=eLIT5fnKmMI&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=2

    public static void multiply(int arr1[][], int arr2[][]) {
        if (arr1[0].length != arr2.length)
            return;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int temp = 0;
                for (int k = 0; k < arr2.length; k++) {
//                    System.out.print(arr1[i][k]+"  "+arr2[k][j] +" , ");
                    temp += (arr1[i][k] * arr2[k][j]);
                }
                System.out.print(temp + "  ");
            }
            System.out.print("\n");
        }
        return;
    }

    public static void main(String[] args) {
        int arr1[][] = {{1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4}};

        int arr2[][] = {{1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3}};
        multiply(arr1, arr2);
    }
}
