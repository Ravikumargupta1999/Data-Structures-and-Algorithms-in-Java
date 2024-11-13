package HashMap_And_Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Arrays {
    static class Pair implements Comparable<Pair>
    {
        int li ;
        int index;
        int val;
        Pair(int li,int index,int val)
        {
            this.li = li;
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i=0;i<lists.size();i++)
        {
            pq.add(new Pair(i,0,lists.get(i).get(0)));
        }
        while (pq.size() > 0)
        {
            Pair rem = pq.poll();
            ans.add(rem.val);
            if(rem.index +1 != lists.get(rem.li).size())
            {
                pq.add(new Pair(rem.li,rem.index+1,lists.get(rem.li).get(rem.index+1)));
            }
        }
        return ans;
    }
}
