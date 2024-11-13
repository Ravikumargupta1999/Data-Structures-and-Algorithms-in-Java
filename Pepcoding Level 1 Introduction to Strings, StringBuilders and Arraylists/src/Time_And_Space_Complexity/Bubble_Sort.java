package Time_And_Space_Complexity;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = {34, 67, 8, 65, 40, -78, 22, 21};
        System.out.print("UnSorted Array : ");
        for (int val : arr)
            System.out.print(val + "\t");
        System.out.print("\n");

        bubbleSort(arr);

        System.out.print("Sorted Array : ");
        for (int val : arr)
            System.out.print(val + "\t");
        System.out.print("\n");
    }

    public static void bubbleSort(int[] arr) {
        for (int itr = 1; itr <= arr.length - 1; itr++) {
            for (int j = 0; j < arr.length - itr; j++) {
                if (isSmaller(arr, j + 1, j))
                    swap(arr, j + 1, j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
        }
    }
}
