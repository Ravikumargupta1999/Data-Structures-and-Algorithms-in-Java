package InterviewQuestion;

import java.util.Collections;
import java.util.PriorityQueue;
// https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
public class Video_70_Find_Median_In_Running_Stream {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void insertHeap(int x) {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            maxHeap.add(x);
        } else if (minHeap.size() == maxHeap.size()) {
//            System.out.println(maxHeap.peek()+"  "+minHeap.peek());
            if (x > maxHeap.peek()) {
                minHeap.add(x);
            } else {
                maxHeap.add(x);
            }
        } else {
            if (maxHeap.size() == 1 && minHeap.size() == 0) {
                if (x >= maxHeap.peek()) {
                    minHeap.add(x);
                } else {

                    minHeap.add(maxHeap.poll());
                    maxHeap.add(x);
                }
            } else {
//                System.out.println(maxHeap.peek()+"  "+minHeap.peek());
                if (minHeap.size() > maxHeap.size()) {
                    if (x <= minHeap.peek()) {
                        maxHeap.add(x);

                    } else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(x);
                    }
                } else {

                    if (x >= maxHeap.peek()) {
                        minHeap.add(x);
                    } else {
//                        System.out.println("H");
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(x);
                    }
                }
            }
        }
    }


    public static double getMedian() {
        if (minHeap.size() == 0) {
            return maxHeap.peek();
        } else {
            if (minHeap.size() == maxHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                if (minHeap.size() > maxHeap.size())
                    return minHeap.peek();
                else
                    return maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 15};
        for (int val : arr) {
            insertHeap(val);
            System.out.println(maxHeap + "   " + minHeap);
            System.out.println(getMedian());
        }
    }
}
// https://leetcode.com/problems/find-median-from-data-stream/submissions/
class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int val) {
        if (left.size() == right.size()) {
            if (left.size() == 0)
                left.add(val);
            else if (val > left.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }
        } else {
            if (left.size() > right.size()) {
                if (val > left.peek()) {
                    right.add(val);
                } else {
                    int temp = left.poll();
                    right.add(temp);
                    left.add(val);
                }
            } else {
                if (val < right.peek()) {
                    left.add(val);
                } else {
                    int temp = right.poll();
                    left.add(temp);
                    right.add(val);
                }
            }
        }
    }

    public double findMedian() {
        if (this.size() == 0) {
            return -1;
        }
        if (left.size() == right.size()) {
            return (left.peek() + right.peek())/2.0;
        } else {
            if (left.size() > right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }
    }

    public int size() {
        return left.size() + right.size();
    }

}
