import java.util.*;
//https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0/?category[]=Hash&category[]=Hash&difficulty[]=1&page=1&query=category[]Hashdifficulty[]1page1category[]Hash#

public class Sorting_Elements_of_an_Array_by_Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            sortByFrequency(arr);
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println("");
        }

    }

    static class Pair {
        int num;
        int count;

    }


    static void sortByFrequency(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int c : arr) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        Pair[] pairArray = new Pair[counts.size()];
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            Pair p = new Pair();
            p.num = entry.getKey();
            p.count = entry.getValue();
            pairArray[l++] = p;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.count != o2.count)
                    return o2.count - o1.count;
                else {
                    return o1.num - o2.num;
                }
            }
        });

        for (int i = 0; i < pairArray.length; i++) {
            pq.add(pairArray[i]);
        }
        int i = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int size = p.count;
            // System.out.println(p.count+"  "+p.num);
            while (size-- > 0)
                arr[i++] = p.num;
        }
    }
}


