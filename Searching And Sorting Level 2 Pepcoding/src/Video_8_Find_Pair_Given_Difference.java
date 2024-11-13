import java.util.Arrays;

public class Video_8_Find_Pair_Given_Difference {
    // Gives TLE
    // As time complexity in worst case goes to O(n^2)
    public boolean findPair(int arr[], int size, int n) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        if (arr.length == 1)
            return false;
        while (j < arr.length && i < arr.length) {

            // important edge case in case i==j increase j and if j becomes equal to arr.length break
            if(i == j){
                j++;
            }
            if( j >= arr.length){
                break;
            }
            if (arr[j] - arr[i] == n)
                return true;
            else if (arr[j] - arr[i] < n)
                j++;
            else
                i++;
        }
        return false;
    }

    boolean findPair1(int arr[], int size, int n) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        if (arr.length == 1)
            return false;
        while (j < arr.length && i < arr.length) {
            if (arr[j] - arr[i] == n)
                return true;
            else if (arr[j] - arr[i] < n)
                j++;
            else
                i++;
        }
        return false;
    }
}
