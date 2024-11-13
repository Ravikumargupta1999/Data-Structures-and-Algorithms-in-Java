import java.util.ArrayList;
import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1
// https://www.youtube.com/watch?v=2Sj6-5JFaAo

public class Greedy_247_Minimum_and_maximum_amount_to_buy_all_N_candies {
    static ArrayList<Integer> candyStore(int arr[], int n, int k) {
        Arrays.sort(arr);
        int max = 0;
        int min = 0;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            min += (arr[i]);
            i++;
            j = j - k;
        }
        ArrayList<Integer> al = new ArrayList<>();
        al.add(min);

        reverse(arr);
        i = 0;
        j = n - 1;
        while (i <= j) {
            max += (arr[i]);
            i++;
            j = j - k;
        }
        al.add(max);
        return al;

    }

    public static void reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {

    }

}
