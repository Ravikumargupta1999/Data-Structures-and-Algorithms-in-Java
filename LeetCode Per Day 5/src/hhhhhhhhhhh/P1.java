package hhhhhhhhhhh;

import java.util.HashMap;
import java.util.PriorityQueue;

public class P1 {
    public static void main(String[] args) {
        int[] arr = {56, 41, 27, 71, 62, 57, 67, 34, 8, 71, 2, 12, 52, 1, 64, 43, 32, 42, 9, 25, 73, 29, 31};
        int k = 52;
        System.out.println(pickGifts(arr, k));
    }

    public static long pickGifts(int[] gifts, int k) {

        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int ch : gifts) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        maxHeap.addAll(counts.keySet());

        while (k-- > 0) {
            int curr = maxHeap.remove();
            int sqrt = (int) (Math.sqrt(curr));
            if (counts.containsKey(sqrt)) {
                counts.put(sqrt,counts.get(sqrt)+1);
            }else {
                counts.put(sqrt,1);
                maxHeap.add(sqrt);
            }

            counts.put(curr,counts.get(curr)-1);
            if(counts.get(curr) == 0){
                counts.remove(curr);
                maxHeap.remove(curr);
            }else{
                maxHeap.add(curr);
            }

        }


        long res = 0;
        for (int num : counts.keySet()) {
            res += (num * (counts.get(num)));
        }
        return res;


    }
}
