import java.util.Scanner;

public class ProductofMaximuminFirstArrayAndMinimuminsecond {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<arr.length;i++)
            arr[i]=s.nextInt();
        System.out.println("");

        int m=s.nextInt();
        int[] arr1=new int[n];
        for (int i=0;i<arr1.length;i++)
            arr1[i]=s.nextInt();
        System.out.println("");
        int value = Product(arr,arr1);
        System.out.println(value);
    }
    public static int Product(int[] arr1,int[] arr2)
    {
        int max = arr1[0];
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]>max)
                max = arr1[i];
        }
        System.out.println(max);
        System.out.println("");
        int min = arr2[0];
        for(int i=0;i<arr2.length;i++)
        {

            if(arr2[i]<min)
                min = arr2[i];
            System.out.println(min);
        }
       // System.out.println(max);
        System.out.println("");
        System.out.println(min);
        return max*min;
    }
}
