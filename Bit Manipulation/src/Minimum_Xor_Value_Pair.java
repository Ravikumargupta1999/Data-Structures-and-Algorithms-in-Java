import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// https://practice.geeksforgeeks.org/problems/minimum-xor-value-pair/0/#
public class Minimum_Xor_Value_Pair {
    public int sumXOR (int arr[], int n) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++)
        {
            if ((arr[i]^arr[i+1] ) < min) {
                min = (arr[i]^arr[i+1] );
            }
        }
        return min;
    }
}
