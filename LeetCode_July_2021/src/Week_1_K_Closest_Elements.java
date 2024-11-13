import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Week_1_K_Closest_Elements {
    public static ArrayList<Integer> findClosestElements(int[] arr, int k, int x)
    {
        ArrayList<Integer> al = new ArrayList<>();
        int post = -1;
        for(int i=0;i<arr.length;i++)
        {
            if(x<arr[i])
            {
                post = i;
                break;
            }
        }
        if(post == -1)
        {

        }

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("");
        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        System.out.println("");
        System.out.println("");
        int k = s.nextInt();
        int x = s.nextInt();
        ArrayList<Integer> al = findClosestElements(arr,k,x);
        for(int i=0;i<al.size();i++)
            System.out.print(al.get(i)+"  ");
        System.out.println("");
    }
}
