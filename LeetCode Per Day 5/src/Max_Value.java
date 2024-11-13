public class Max_Value {
    public static int maxVal(int a[], int n) {
        int max = Integer.MIN_VALUE;

        int min =  Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            max = Math.max(max,a[i]-i);
            min = Math.min(min,a[i]-i);
        }
        return max - min;

    }

}
