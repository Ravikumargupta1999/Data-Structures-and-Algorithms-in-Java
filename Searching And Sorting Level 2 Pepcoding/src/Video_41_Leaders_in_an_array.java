import java.util.ArrayList;
import java.util.Collections;

//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
public class Video_41_Leaders_in_an_array {
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                al.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(al);
        return al;
    }

    public static void main(String[] args) {
        int[] arr = {};
    }
}
