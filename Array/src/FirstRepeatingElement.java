import java.util.HashMap;
import java.util.Scanner;
// https://practice.geeksforgeeks.org/problems/first-repeating-element4018/1/?category[]=Arrays&category[]=Arrays&page=2&query=category[]Arrayspage2category[]Arrays#
public class FirstRepeatingElement {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i]=s.nextInt();
        System.out.println("");
        int value  = FirstRepeat(arr,n);
        System.out.println(value);
    }
    public static int FirstRepeat(int[] arr,int n)
    {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(!hs.containsKey(arr[i]))
                hs.put(arr[i],0);
            hs.put(arr[i],hs.get(arr[i])+1);
        }
        //System.out.println(hs);
        int i=0;
        for(;i<n;i++)
        {
            if(hs.get(arr[i])>1)
                break;
        }
        if(i<n)
            return i+1;
        return -1;
    }
}
