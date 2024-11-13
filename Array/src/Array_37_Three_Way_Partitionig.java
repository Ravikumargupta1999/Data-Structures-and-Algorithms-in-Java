import java.util.Scanner;

public class Array_37_Three_Way_Partitionig {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements :  ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = s.nextInt();
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println();
        System.out.print("Enter the range :  ");
        int a = s.nextInt();
        int b = s.nextInt();
        int res = ThreeWayPartition(arr, a, b);
        System.out.println();
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");

    }

    public static int ThreeWayPartition(int[] array, int a, int b) {
        int start = 0;
        int end = array.length - 1;
        for (int i = 0; i <= end; ) {
            if (array[i] < a) {
                int temp = array[i];
                array[i] = array[start];
                array[start] = temp;
                start++;
                i++;
            } else if (array[i] > b) {
                int temp = array[i];
                array[i] = array[end];
                array[end] = temp;
                end--;
            } else
                i++;
        }
        return 1;
    }
}
