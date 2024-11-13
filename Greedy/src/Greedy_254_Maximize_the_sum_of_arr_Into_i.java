import java.util.Arrays;

//
public class Greedy_254_Maximize_the_sum_of_arr_Into_i {
    // https://practice.geeksforgeeks.org/problems/maximize-arrii-of-an-array0026/1
    // https://www.youtube.com/watch?v=Rax27fL0iIU
    int Maximize(int arr[], int n) {
        Arrays.sort(arr);
        int m = 1000000007;
        long s = 0;
        for (int i = 0; i < arr.length; i++) {
            s = s % m + ((long) arr[i] * i) % m;
        }

        return (int) s % m;
    }
}
