import java.util.PriorityQueue;
// https://practice.geeksforgeeks.org/problems/operations-on-priorityqueue/1/?category[]=Queue&category[]=Queue&page=1&query=category[]Queuepage1category[]Queue

public class Operations_on_PriorityQueue {
    static void insert(PriorityQueue<Integer> q, int k){

        q.add(k);
    }

    // Function to find an element k
    static boolean find(PriorityQueue<Integer> q, int k){

        return  q.contains(k);
    }

    // Function to delete the max element from queue
    static int delete(PriorityQueue<Integer> q){

     q.poll();

    }
    public static void main(String[] args) {

    }
}
