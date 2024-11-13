import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
public class Missing_Number_Gfg {
    static int MissingNumber(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr.length+1)
                continue;
            while (arr[i] != i + 1) {
                System.out.println(i+"  "+arr[i]+"  "+arr[arr[i]-1]);
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                if(arr[i] == arr.length+1)
                    break;
            }
        }
        for(int i=0;i<arr.length;i++)
            if(i + 1 != arr[i])
                return i+1;

        return arr.length+1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 2, 8, 3, 4, 7, 10, 5};
        System.out.println(MissingNumber(arr, arr.length + 1));
    }
}
