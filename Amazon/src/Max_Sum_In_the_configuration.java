public class Max_Sum_In_the_configuration {
    static int max_sum(int arr[], int n)
    {
        int max = Integer.MIN_VALUE;
        for(int d =0; d <n;d++) {

            reverse(arr, 0, d-1);
            reverse(arr, d, n -1);
            reverse(arr, 0, n - 1);
            for(int i=0;i<n;i++)
                System.out.print(arr[i]+"  ");
            System.out.println("");
            int product = 0;
            for(int i=0;i<n;i++)
                product += (i*arr[i]);
            if(max < product)
                max = product;
        }
        return max;
    }
    public static void reverse(int[] arr,int low,int high)
    {
        while (low <= high)
        {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,3,1,2};
        System.out.println(max_sum(arr,arr.length));
    }
}
