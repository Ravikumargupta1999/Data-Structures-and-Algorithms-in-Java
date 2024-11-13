import java.util.Arrays;

public class Video_39_largest_Number_From_Digits {
    // https://practice.geeksforgeeks.org/problems/form-largest-number-from-digits5430/1/#
    public String MaxNumber(long[] arr, long n) {
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (long i = n - 1; i >= 0; i--) {
            sb.append(arr[(int) i]);
        }
        return sb.toString();
    }

}
