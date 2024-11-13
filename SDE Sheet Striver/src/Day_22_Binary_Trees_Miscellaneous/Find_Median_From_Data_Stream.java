package Day_22_Binary_Trees_Miscellaneous;

import java.util.Collections;
import java.util.PriorityQueue;

public class Find_Median_From_Data_Stream {
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
                return (left.peek() + right.peek()) / 2.0;
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

}
