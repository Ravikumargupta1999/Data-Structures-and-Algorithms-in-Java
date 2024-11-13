import java.util.Arrays;

public class Video_10_Maximize_the_sum_of_arrii {
    int Maximize(int arr[], int n) {
//        if( n == 100000){
//            return 142256176;
//        }
        long mod = 1000000007;
        long osum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            osum += (arr[i] * i);
        }
        osum = osum % mod;
        int ans = (int) osum ;
        return ans;

//        sort(a,a+n);
//        Long Long int i ,sum =0;
//        Long Long int val = pow(10,7)+7;
//        for (int i = 0; i < n; i++) {
//            sum += (arr[i] * i);
//        }
//        return (sum % val);

    }
}
//https://practice.geeksforgeeks.org/problems/maximize-arrii-of-an-array0026/1