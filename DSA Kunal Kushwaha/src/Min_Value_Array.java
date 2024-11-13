public class Min_Value_Array {
    public static int minValue(int[] arr)
    {
        return minimumValue(arr,1,arr[0]);
    }
    public static int minimumValue(int[] arr,int index,int min)
    {
        if (index == arr.length)
            return min;
        if(arr[index] < min)
            return minimumValue(arr,index+1,arr[index]);
        else
            return minimumValue(arr,index+1,min);
    }
    public static void main(String[] args) {
        System.out.println(minValue(new int[]{12}));
    }
}
