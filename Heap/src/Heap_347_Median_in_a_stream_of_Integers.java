import java.util.Collections;
import java.util.PriorityQueue;
// https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1#
public class Heap_347_Median_in_a_stream_of_Integers {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static void insertHeap(int x)
    {
        if(maxHeap.size() == 0 && minHeap.size() == 0){
            maxHeap.add(x);
        }
        else  if(minHeap.size() == maxHeap.size()){
//            System.out.println(maxHeap.peek()+"  "+minHeap.peek());
            if(x  > maxHeap.peek()){
                minHeap.add(x);
            }
            else {
                maxHeap.add(x);
            }
        }
        else {
            if(maxHeap.size() == 1 && minHeap.size() == 0){
                if(x >= maxHeap.peek()){
                    minHeap.add(x);
                }
                else {

                    minHeap.add(maxHeap.poll());
                    maxHeap.add(x);
                }
            }else {
//                System.out.println(maxHeap.peek()+"  "+minHeap.peek());
                if(minHeap.size() > maxHeap.size()){
                    if(x <= minHeap.peek()){
                        maxHeap.add(x);

                    }
                    else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(x);
                    }
                }else {

                    if(x >= maxHeap.peek()){
                        minHeap.add(x);
                    }
                    else {
//                        System.out.println("H");
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(x);
                    }
                }
            }
        }
    }
    public static void balanceHeaps()
    {
    }
    public static double getMedian()
    {
        if(minHeap.size() == 0){
            return maxHeap.peek();
        }
        else {
            if(minHeap.size() == maxHeap.size()){
                return (maxHeap.peek() + minHeap.peek())/2.0;
            }else {
                if(minHeap.size() > maxHeap.size())
                    return minHeap.peek();
                else
                    return maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,10,15};
        for(int i=0;i<arr.length;i++){
            insertHeap(arr[i]);
            System.out.println(maxHeap+"   "+minHeap+"   "+getMedian());

        }
    }
}
