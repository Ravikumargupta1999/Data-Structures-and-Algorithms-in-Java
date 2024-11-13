import java.util.Arrays;
import java.util.Scanner;

public class SearchingSorting1114WithoutExtraaSpace1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] arr1=new int[n];
        for (int i=0;i<n;i++)
            arr1[i]=s.nextInt();
        int m=s.nextInt();
        int[] arr2=new int[m];
        for (int i=0;i<m;i++)
            arr2[i]=s.nextInt();
        Merge(arr1,arr2,n,m);

    }
    public static void Merge(int[] arr1,int[] arr2,int n,int m)
    {
        int i= n-1;
        int j=0;
        while(i>=0 && j<m)
        {
            if(arr1[i]>=arr2[j])
            {
                int temp = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = temp;
                i--;
                j++;
            }
            else
                break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("");
        for (int l=0;l<n;l++)
            System.out.print(arr1[l]+" ");
        System.out.println("");
        for (int l=0;l<m;l++)
            System.out.print(arr2[l]+" ");

    }
}
