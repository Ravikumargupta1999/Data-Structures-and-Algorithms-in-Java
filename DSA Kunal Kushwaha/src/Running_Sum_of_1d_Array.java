public class Running_Sum_of_1d_Array {
    public int[] runningSum(int[] arr) {
        int sum =0;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;

    }
}
