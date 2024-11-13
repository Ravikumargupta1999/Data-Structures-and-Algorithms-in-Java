package Day_13_Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_Using_Queue {
//    public class stack {
//        Queue<Integer> q1;
//        Queue<Integer> q2;
//
//        public stack() {
//            // Implement the Constructor.
//            q1 = new LinkedList<>();
//            q2 = new LinkedList<>();
//        }
//
//
//
//        /*----------------- Public Functions of Stack -----------------*/
//
//
//        public int getSize() {
//            // Implement the getSize() function.
//            return q1.size() + q2.size();
//        }
//
//        public boolean isEmpty() {
//            // Implement the isEmpty() function.
//
//            return getSize() == 0;
//        }
//
//        public void push(int element) {
//            q1.add(element);
//        }
//
//        public int pop() {
//            if (getSize() == 0)
//                return -1;
//
//            while (q1.size() > 1) {
//                q2.add(q1.poll());
//            }
//            int val = q1.poll();
//
//            while (!q2.isEmpty())
//                q1.add(q2.poll());
//            return val;
//        }
//
//        public int top() {
//            if (getSize() == 0)
//                return -1;
//
//            while (q1.size() > 1) {
//                q2.add(q1.poll());
//            }
//            int val = q1.peek();
//            q2.add(q1.poll());
//            while (!q2.isEmpty())
//                q1.add(q2.poll());
//            return val;
//        }
//    }
}
