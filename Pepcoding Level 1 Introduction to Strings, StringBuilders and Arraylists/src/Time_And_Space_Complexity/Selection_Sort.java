package Time_And_Space_Complexity;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {34, 67, 8, 65, 40, -78, 22, 21};
        System.out.print("UnSorted Array : ");
        for (int val : arr)
            System.out.print(val + "\t");
        System.out.print("\n");

        selectionSort(arr);

        System.out.print("Sorted Array : ");
        for (int val : arr)
            System.out.print(val + "\t");
        System.out.print("\n");
    }
    public static void selectionSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++)
        {
            int min = i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(isSmaller(arr,j,min))
                    min = j;
            }
            swap(arr,i,min);
        }
    }

    // used for swapping ith and jth elements of array
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

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
