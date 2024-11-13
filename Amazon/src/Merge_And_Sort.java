import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/merge-and-sort5821/1/?category[]=Merge%20Sort&category[]=Merge%20Sort&page=1&query=category[]Merge%20Sortpage1category[]Merge%20Sort#

public class Merge_And_Sort {
    public static int mergeNsort2(int a[], int b[], int n, int m, int answer[])
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        for(int i=0;i<m;i++)
            map.put(b[i],map.getOrDefault(b[i],0)+1);
        ArrayList<Integer> al = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
            al.add(entry.getKey());
        Collections.sort(al);
        for(int i=0;i<al.size();i++)
            answer[i] = al.get(i);
        return al.size();



    }

    public static int mergeNsort(int a[], int b[], int n, int m, int answer[])
    {
        Arrays.sort(a);
        Arrays.sort(b);


        //for(int i=0)
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m )
        {
            if(a[i]<=b[j])
            {
                answer[k] = a[i];
                i++;
                k++;
            }
            else
            {
                answer[k] = b[j];
                j++;
                k++;
            }
        }
        while (i<n)
        {
            answer[k] = a[i];
            i++;
            k++;
        }
        while (j<m)
        {
            answer[k] = b[j];
            j++;
            k++;
        }

        for(int l=0;l<k;l++)
        {
            System.out.print(answer[l]+"  ");
        }
        System.out.println("");
        return k;

    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {7, 1, 5, 3, 9};
        int m = 6;
        int[] arr2 = {8, 4, 3,5, 2, 6};
        int[] arr = new int[n+m];
        System.out.println(mergeNsort(arr1,arr2,n,m,arr));

    }
}
