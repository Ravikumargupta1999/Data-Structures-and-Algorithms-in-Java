public class FindMin {
    static int minElement(int[] arr)
    {
        int min = arr[0];
        for(int i=1;i<arr.length;i++)
            if(arr[i] < min)
                min = arr[i];
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,-1,4,5,-183,78};
        System.out.println(minElement(arr));
    }
}
