package HashMap_And_Heaps;
// median Priority Queue pepcoding
import java.util.Collections;
import java.util.PriorityQueue;

public class Median_Priority_Queue {
    public static class MedianPriorityQueue {

        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            if(left.size() == right.size()) {
                if (left.size() == 0)
                    left.add(val);
                else if( val > left.peek())
                {
                    right.add(val);
                }
                else
                {
                    left.add(val);
                }
            }
            else {
                if(left.size() > right.size())
                {
                    if(val > left.peek() )
                    {
                        right.add(val);
                    }
                    else
                    {
                        int temp = left.poll();
                        right.add(temp);
                        left.add(val);
                    }
                }
                else
                {
                    if(val < right.peek())
                    {
                        left.add(val);
                    }
                    else
                    {
                        int temp = right.poll();
                        left.add(temp);
                        right.add(val);
                    }
                }
            }
        }

        public int remove() {
            if(this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if(left.size() == right.size())
            {
                return left.poll();
            }
            else
            {
                if(left.size() > right.size())
                {
                    return left.poll();
                }
                else
                {
                    return right.poll();
                }
            }
        }

        public int peek() {
            if(this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if(left.size() == right.size())
            {
                return left.peek();
            }
            else
            {
                if(left.size() > right.size())
                {
                    return left.peek();
                }
                else
                {
                    return right.peek();
                }
            }

        }

        public int size() {
            return left.size() + right.size();
        }

    }

    public static void main(String[] args) {
        MedianPriorityQueue queue = new MedianPriorityQueue();
        queue.add(10);
        queue.remove();
    }
}
//10
//        30
//        20
//        40
//        20
//        20
//        50
//        50
//        60
//add 10
//        remove
//        peek
//        add 30
//        remove
//        peek
//        peek
//        add 20
//        add 50
//        peek
//        add 40
//        remove
//        peek
//        remove
//        peek
//        remove
//        peek
//        add 60
//        peek
//        quit