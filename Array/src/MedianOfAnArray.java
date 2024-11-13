import java.util.Scanner;

public class MedianOfAnArray
{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++)
            arr[i]=s.nextInt();
        Solution s1=new Solution();
        int x=s1.find_fact(arr);
        System.out.println(x);

    }

}
class Solution{
    public int find_fact(int[] v)
    {
        quickSort(v,0,v.length-1);
        for(int i=0;i<v.length;i++)
            System.out.print(v[i]+"  ");
        System.out.println();
        int median;
        if(v.length%2==0)
        {
            int value=v[(v.length/2)-1]+v[v.length/2];
                return value/2;


        }
        else {
            median = (v.length / 2);
            return v[median];
        }


    }
    public static void  quickSort(int[] arr,int start,int end)
    {

        if(start>=end)
            return;
        else
        {
            int partitionIndex=Partition(arr,start,end);
            quickSort(arr,start,partitionIndex-1);
            quickSort(arr,partitionIndex+1,end);
        }
    }
    public static  int Partition(int[] arr,int start,int end)
    {
        int pivot=arr[end];
        int partitionIndex=start;

        for(int i=start;i<end;i++)
        {
            if(arr[i]<=pivot)
            {
                int temp=arr[i];
                arr[i]=arr[partitionIndex];
                arr[partitionIndex]=temp;
                partitionIndex++;
            }
        }
        int temp=arr[partitionIndex];
        arr[partitionIndex]=arr[end];
        arr[end]=temp;
        return  partitionIndex;

    }

}
