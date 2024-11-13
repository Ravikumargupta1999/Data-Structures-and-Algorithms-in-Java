import java.util.*;

public class Top_k_numbers_in_a_stream {
    // My solution;
    static ArrayList<Integer> kTop(int[] arr, int n, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            if (counts.get(b) == counts.get(a)) {
                return a - b;
            } else {
                return counts.get(b) - counts.get(a);
            }
        });
//        maxHeap.addAll(counts.keySet());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            counts.put(arr[i],counts.getOrDefault(arr[i],0)+1);
            maxHeap.addAll(counts.keySet());
            int size = 0;
            if(maxHeap.size() < k)
                size = maxHeap.size();
            else
                size = k;
//            System.out.print(counts+"  ");
            int[] temp1 = new int[size];
            int l = 0;
            int[] temp2 = new int[size];
            while (l < size) {
                int current = maxHeap.remove();
                result.add(current);
                temp1[l] = current;
                temp2[l] = counts.get(current);
                l++;
            }
//            for (int j = 0; j < temp1.length; j++) {
//                counts.put(temp1[j], temp2[j]);
//            }
            while (!maxHeap.isEmpty())
                maxHeap.poll();
//            System.out.println(result);
        }
        return result;
    }
    // improved : removed unnecessary steps
    static ArrayList<Integer> kTop1(int[] arr, int n, int k)
    {
        Map<Integer, Integer> counts = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            if (counts.get(b) == counts.get(a)) {
                return a - b;
            } else {
                return counts.get(b) - counts.get(a);
            }
        });
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            counts.put(arr[i],counts.getOrDefault(arr[i],0)+1);
            maxHeap.addAll(counts.keySet());
            int size = 0;
            if(maxHeap.size() < k)
                size = maxHeap.size();
            else
                size = k;
            int l =0;
            while (l < size) {
                int current = maxHeap.remove();
                result.add(current);
                l++;
            }
            while (!maxHeap.isEmpty())
                maxHeap.poll();
        }
        return result;
    }
    public static void main(String[] args) {
//        int[] arr = {18, 11, 19, 14, 17, 4, 4,5, 12, 13, 7, 7, 11, 19, 16, 3, 17, 20, 11, 17, 15, 6, 4, 9};
        int[] arr = {5, 2, 1, 3, 4};
        System.out.println(kTop(arr,arr.length,4));
    }
}
