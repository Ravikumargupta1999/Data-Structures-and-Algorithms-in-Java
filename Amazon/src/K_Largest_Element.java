import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon#

public class K_Largest_Element {
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++)
        {
            pq.add(arr[i]);
        }
        for(int i=k;i<n;i++)
        {
            if(pq.peek() > arr[i])
                continue;
            pq.poll();
            pq.add(arr[i]);
        }
        System.out.println(pq);
        ArrayList<Integer> al = new ArrayList<>();
        while (!pq.isEmpty())
        {
            al.add(pq.poll());
        }
        System.out.println(al);
        Collections.reverse(al);
        return al;

    }

    public static void main(String[] args) {
        int N = 5, k = 2;
        int arr[] = {12,5,787,1,23};
        System.out.println(kLargest(arr,N,k));

    }
}
