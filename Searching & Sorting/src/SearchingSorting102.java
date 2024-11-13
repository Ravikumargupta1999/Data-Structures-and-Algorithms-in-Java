import java.util.ArrayList;
import java.util.Scanner;

public class SearchingSorting102 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++)
            arr[i] = s.nextInt();

        ArrayList<Integer> al = valueEqualToIndex(arr,n);
        System.out.println(al);
    }
    public static ArrayList<Integer> valueEqualToIndex(int[] arr,int n)
    {
        ArrayList<Integer> al= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]==i+1)
                al.add(i+1);
        }
        return al;
    }

}
