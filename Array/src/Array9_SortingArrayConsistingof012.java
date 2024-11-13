import java.util.Scanner;
//Done
class Array9_SortingArrayConsistingof012 {
    // https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
    public static void sort012(int arr[], int n) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < n; i++) {
            switch (arr[i]) {
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;


            }

        }
        int i = 0;
        while (zero > 0) {
            arr[i++] = 0;
            zero--;
        }
        while (one > 0) {
            arr[i++] = 1;
            one--;
        }
        while (two > 0) {
            arr[i++] = 2;
            two--;
        }

    }
}
