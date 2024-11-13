import java.util.*;

public class Company {
    public static int check(int[] arr,int k)
    {
        for(int i=0;i<arr.length;i++)
        {
            if( i == 0 &&  k < arr[i])
            {
                return -1;
            }
            else if( i == arr.length-1 && arr[i] > k)
            {
                return arr.length;
            }
            else
            {
                if(i != 0 && k > arr[i-1] && k < arr[i])
                {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++)
            arr[i] = s.nextInt();
        System.out.println(check(arr,k));
    }
}
