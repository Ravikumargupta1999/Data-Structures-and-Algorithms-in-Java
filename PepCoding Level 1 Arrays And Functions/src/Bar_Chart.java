public class Bar_Chart {
    public static void main(String[] args) {
        int[] arr = {8, 6, 4, 2, 1, 3, 3, 4, 1, 8, 4, 5, 2, 5, 6};
        barPlot(arr);
    }

    static void barPlot(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        for (int temp = max; temp > 0; temp--) {
            for (int i = 0; i < arr.length; i++) {
                if (temp == arr[i]) {
                    arr[i] = arr[i] - 1;
                    System.out.print("* ");
                } else
                    System.out.print("  ");
            }
            System.out.println("");
        }
    }
}
