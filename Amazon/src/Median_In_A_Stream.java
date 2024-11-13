import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


// https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
// https://www.youtube.com/watch?v=NIUgvZxt3Lg
public class Median_In_A_Stream {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static void insertHeap(int x)
    {
        if(maxHeap.size() == minHeap.size())
        {
            if(maxHeap.size() == 0)
            {
                maxHeap.add(x);
                return;
            }
            if(x < maxHeap.peek())
            {
                maxHeap.add(x);
            }
            else
            {
                minHeap.add(x);
            }
        }
        else
        {
            if(maxHeap.size() > minHeap.size())
            {
                if(x >= maxHeap.peek())
                {
                    minHeap.add(x);
                }
                else
                {
                    int temp = maxHeap.peek();
                    maxHeap.poll();
                    minHeap.add(temp);
                    maxHeap.add(x);
                }
            }
            else
            {
                if(x <= minHeap.peek())
                {
                    maxHeap.add(x);
                }
                else
                {
                    int temp = minHeap.peek();
                    minHeap.poll();
                    maxHeap.add(temp);
                    minHeap.add(x);
                }
            }
        }


    }
    public static double getMedian()
    {
        if(minHeap.size() == maxHeap.size())
        {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else
        {
            if(minHeap.size()> maxHeap.size())
            {

                return (int)minHeap.peek();
            }
            else
            {
                return (int)maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={5,10,15};
        for(int i=0;i<arr.length;i++)
        {
            insertHeap(arr[i]);
            System.out.print(maxHeap+"  "+minHeap+"  ");
            System.out.print(getMedian()+"  ");
            System.out.println("");
        }
        System.out.println("");
    }


}
