public class ArrayPassing {
    public static void passingArray(int[] arr)
    {
        for (int i = 0;i<arr.length;i++)
        {
            arr[i] = i * i * i;
        }

        for(int i=0 ;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i=0 ;i<arr.length;i++)
           arr[i] = i*i;
        System.out.println("");
        for(int i=0 ;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
        passingArray(arr);
        for(int i=0 ;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println("");

    }
}
