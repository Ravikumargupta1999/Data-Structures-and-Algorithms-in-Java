import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heap_341_Merge_Sorted_Arrays {
    // https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
    static class Pair {
        int index;
        int val;
        int k;

        public Pair(int index, int val, int k) {
            this.index = index;
            this.val = val;
            this.k = k;
        }
    }

    public static ArrayList<Integer> mergeKSortedArrays(int[][] arr, int k) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new Pair(0, arr[i][0], i));
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Pair rem = priorityQueue.poll();
            res.add(rem.val);
            if (rem.index < arr[rem.k].length - 1)
                priorityQueue.add(new Pair(rem.index + 1, arr[rem.k][rem.index + 1], rem.k));
        }
        return res;
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        int i = 0;
        int last = arr.length - 1;
        int j;
        while (last != 0) {
            i = 0;
            j = last;
            while (i < j) {
                arr[i] = merge(arr[i], arr[j]);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }
            }
        }
        ArrayList<Integer> list = java.util.stream.IntStream.of(arr[0])
                .boxed()
                .collect(java.util.stream.Collectors.toCollection(ArrayList::new));
        return list;
    }

    public static int[] merge(int[] arr1, int[] arr2) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr1.length; i++)
            pq.add(arr1[i]);
        for (int i = 0; i < arr2.length; i++)
            pq.add(arr2[i]);
        int[] arr3 = new int[pq.size()];
        for (int i = 0; i < arr3.length; i++)
            arr3[i] = pq.remove();
        return arr3;

    }

    public static void main(String[] args) {
        int K = 4;
        int arr[][] = {{1, 2, 3, 4}, {2, 2, 3, 4},
                {5, 5, 6, 6}, {7, 8, 9, 9}};
        ArrayList<Integer> al = mergeKSortedArrays(arr, K);
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + "  ");

    }
}
