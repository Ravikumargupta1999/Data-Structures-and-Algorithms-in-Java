import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1?page=5&company[]=Amazon&sortBy=submissions
public class Practice_1_Frequencies_Of_Limited_Range_Array_Elements {
    public static void frequencyCount(int arr[], int N, int P) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++)
            map.put(i, 0);
        for (int a : arr)
            if (a > 0 && a < N + 1)
                map.put(a, map.get(a) + 1);
        for (int i = 0; i < N; i++) {
            arr[i] = map.get(i + 1);
        }
    }

    // https://www.youtube.com/watch?v=UW1InjlrXFU
    public static void frequencyCount1(int[] arr, int n, int P) {
        //Step 1: Reduce all Element
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - 1;
        }
        System.out.println("Step 1 result :  " + Arrays.toString(arr));
        // Step 2 : For i = 0 to n-1 , add n to arr[i] % n

        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += n;
        }

        System.out.println("Step 2 result :  " + Arrays.toString(arr));

        // Step 3 : Restore Frequency;
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / n;

        System.out.println("Step 3 result :  " + Arrays.toString(arr));
    }

    public static void frequencyCount2(int arr[], int n, int P) {
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1)
                count1++;
            if (arr[i] <= n)
                arr[i] = arr[i] - 1;
            else {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
        arr[0] = count1;

    }
}
