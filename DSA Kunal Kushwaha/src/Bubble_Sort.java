public class Bubble_Sort {
    static void bubbleSort(int[] arr) {
        boolean swapped;
        // run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            // for each step, max item will come at the last respective index
            for (int j = 1; j < arr.length - i; j++) {
                // swap if the item is smaller than the previous item
                if (arr[j] < arr[j - 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
//            System.out.print(i+" :  ");
//            for(int k=0;k<arr.length-1;k++)
//                System.out.print(arr[k]+"  ");
//            System.out.println("");
            // if you did not swap for a particular value of i, it means the array is sorted hence stop the program
            if (!swapped) { // !false = true
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
