package Day_2_Arrays;

public class Repeating_And_Missing_Number {
    //https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
    int[] findTwoElement(int[] arr, int n) {

        for (int i = 0; i < n; i++) {

            while (arr[i] != i + 1 && arr[i] != arr[arr[i] - 1]) {
                int index = arr[i] - 1;
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return new int[]{arr[i], i + 1};
            }
        }
        return new int[]{-1};
    }
}
