package Time_And_Space_Complexity;

public class Partioning_an_Array {
    public static void main(String[] args) {
        int[] arr = {84,94,12,6,27,62,3,67,22,59,89,43,90,32,45,67,56};
        for(int val : arr)
            System.out.print(val+"\t");
        System.out.println("\n");


        partition(arr,56);


        System.out.println("\n");
        for(int val : arr)
            System.out.print(val+"\t");
        System.out.println("\n");
    }

    public static void partition(int[] arr, int pivot){
       int i =0;
       int j = 0;
       while (i < arr.length)
       {
           if( arr[i] > pivot)
           {
               i++;
           }
           else
           {
               swap(arr,i,j);
               i++;
               j++;
           }
       }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
