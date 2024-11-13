import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/page-faults-in-lru5603/1
// https://www.youtube.com/watch?v=dYIoWkCvd6A
public class Greedy_259_Page_Faults_in_LRU {
    static int pageFaults(int n, int c, int[] arr){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {

            if (queue.size() == c) {
                if (!queue.contains(arr[i])) {
                    queue.poll();
                    queue.add(arr[i]);
                    count++;
                } else {
                    queue.remove(arr[i]);
                    queue.add(arr[i]);
                }
            } else {
                if (queue.contains(arr[i])) {
                    queue.remove(arr[i]);
                    queue.add(arr[i]);
                } else {
                    queue.add(arr[i]);
                    count++;
                }
            }


        }

        return count;
    }
    public static void main(String[] args) {
        int N = 9, C = 4;
        int[] pages = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        System.out.println("No of page fault : " + pageFaults(N, C, pages));

    }
}
