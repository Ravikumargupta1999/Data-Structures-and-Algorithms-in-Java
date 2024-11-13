import java.util.ArrayList;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Arrayscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Arrays#

public class Nearly_Sorted {
    //Function to return the sorted array.
    public static ArrayList<Integer> nearlySorted(int arr[], int n, int k)
    {
        PriorityQueue<Integer> meanHeap = new PriorityQueue<>();
        for (int i=0;i<=k;i++)
        {
            meanHeap.add(arr[i]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = k+1;i<n;i++)
        {
            arrayList.add(meanHeap.poll());
            meanHeap.add(arr[i]);
        }
        while (!meanHeap.isEmpty())
        {
            arrayList.add(meanHeap.poll());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        int arr[] = {3,1,4,2,5};
        System.out.println(nearlySorted(arr,n,k));
    }
}
