import java.util.Arrays;
//Done
class Array10_Move_all_Negative_Numbers_To_beginning {
    public static void main(String[] args) {
        int[] arr = {-12, -11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(arr));
        Rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void Rearrange(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
            System.out.print(" i = " + i + ", j = " + j + "  :  ");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + "  ");
            }
            System.out.println("");
        }
    }
}

