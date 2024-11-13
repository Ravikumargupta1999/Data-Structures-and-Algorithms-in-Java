public class Maximum_AND_Value {
    // Function for finding maximum AND value.
    public static int maxAND (int arr[], int n) {
        if( n == 1)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            for(int j= i+1;j<n;j++)
                if((arr[i] & arr[j]) > max)
                    max = arr[i] & arr[j];
        return max;
    }

    public static void main(String[] args) {
        int N = 4;
        int arr[] = {4, 8, 16, 2};
        System.out.println(maxAND(arr,N));
    }
}
