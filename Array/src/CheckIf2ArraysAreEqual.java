import java.util.HashMap;
import java.util.Scanner;

public class CheckIf2ArraysAreEqual {
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
        boolean value = ifArrrayEqual(arr,arr1);
        System.out.println(value);
    }
    public static boolean ifArrrayEqual(int[] arr1,int[] arr2)
    {
        HashMap<Integer,Integer> hashMap1 = new HashMap<>();
        for(int i=0;i<arr1.length;i++)
        {
            if(hashMap1.containsKey(arr1[i]))
            {
                hashMap1.put(arr1[i],hashMap1.get(arr1[i])+1);
            }
            else
            {
                hashMap1.put(arr1[i],1);
            }
        }
        HashMap<Integer,Integer> hashMap2 = new HashMap<>();
        for(int i=0;i<arr1.length;i++)
        {
            if(hashMap2.containsKey(arr2[i]))
            {
                hashMap2.put(arr2[i],hashMap2.get(arr2[i])+1);
            }
            else
            {
                hashMap2.put(arr2[i],1);
            }
        }
        for(int i=0;i<arr1.length;i++)
        {
            if(hashMap1.containsKey(arr1[i]))
            {
                if(hashMap2.containsKey(arr1[i]))
                {
                    if(hashMap1.get(arr1[i]) == hashMap2.get(arr1[i]));
                    else
                        return false;
                }
                else
                    return false;
            }

        }
        return true;
    }
}
