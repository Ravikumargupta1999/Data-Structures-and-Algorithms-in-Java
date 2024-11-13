public class Rotate_An_Array_Anti_Clockwise {
    public static void main(String[] args) {
        int[] arr = {3,4,5,4,67,61,27};
        rotate(arr,1);

        for(int val: arr)
            System.out.print(val+"  ");
        System.out.println("");
    }
    static void rotate(int[] arr,int k)
    {
        k = k % arr.length;
        if( k< 0)
            k = k + arr.length;
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    static void reverse(int[] arr,int i,int j)
    {
        while (i < j)
        {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }

    }
}
