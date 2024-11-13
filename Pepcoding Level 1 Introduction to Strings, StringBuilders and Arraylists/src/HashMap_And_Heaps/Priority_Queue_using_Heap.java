package HashMap_And_Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Priority_Queue_using_Heap {

    public static class PriorityQueue {
        ArrayList<Integer> arrayList;

        public PriorityQueue() {
            arrayList = new ArrayList<>();
        }

        public void add(int val) {
            arrayList.add(val);
            int ci = arrayList.size() - 1;
            int pi = (ci - 1) / 2;
            while (pi >= 0 && arrayList.get(ci) < arrayList.get(pi)) {
                swap(arrayList, ci, pi);
                ci = pi;
                pi = (ci - 1) / 2;
            }
        }

        public void swap(ArrayList<Integer> al, int i, int j) {
            int temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(j));
            al.set(j, temp);
        }

        public int peek() {
            if (arrayList.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return arrayList.get(0);
        }

        public int remove() {
            if (arrayList.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            swap(arrayList,0,arrayList.size()-1);
            int temp =  arrayList.remove(arrayList.size() - 1);
            int pi = 0;
            boolean found = false;
            while (pi < arrayList.size()) {
                int left = 2 * pi + 1;
                int right = 2 * pi + 2;
                int min = pi;
                if(left < arrayList.size() && arrayList.get(left) < arrayList.get(pi))
                {
                    min = left;
                }
                if( right  < arrayList.size() && arrayList.get(right) < arrayList.get(min))
                {
                    min = right;
                }
                if(min != pi){
                    swap(arrayList,min,pi);
                    pi = min;
                }
                else
                    break;
            }
            return temp;
        }

        public int size() {
            return arrayList.size();
        }
    }


    public static void main(String[] args) {
//        Priority_Queue_using_Heap queue = new Priority_Queue_using_Heap();
//        int[] arr = {10, 20, 30, 40, 35, 45, 42, 55, 50, 15, 5, 17};
//        for (int val : arr) {
//            queue.add(val);
//            System.out.println(queue.peek());
////            System.out.println("\n\n");
//        }


    }
}
