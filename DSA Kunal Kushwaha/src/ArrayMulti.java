public class ArrayMulti {
    public static void passingArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = i * j * j * i;

        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][4];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = i * j;

        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
        passingArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");

    }
}
