import java.net.Inet4Address;
import java.util.HashMap;
// https://www.youtube.com/watch?v=BQaiNwwxvKY&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=32
// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/submissions/

public class Minimize_Hamming_Distance_After_Swap_Operations {
    int[] par;
    public int findPar(int u)
    {
        if(par[u] == u)
            return u;
        return par[u] = findPar(par[u]);
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        par = new int[n];
        for(int i=0;i<n;i++)
        {
            par[i] = i;

        }
        for(int[] swaps : allowedSwaps)
        {
            int a = swaps[0];
            int b = swaps[1];
            int p1 = findPar(a);
            int p2 = findPar(b);
            if(p1 != p2)
            {
                par[p2] = p1;
            }
        }

        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int root = findPar(i);
            int num = source[i];
            if(!map.containsKey(root))
            {
                map.put(root,new HashMap<>());
            }
            HashMap<Integer,Integer> s = map.get(root);
            if(s.containsKey(num))
            {
                s.put(num,s.get(num)+1);
            }
            else
            {
                s.put(num,1);
            }
        }

        int hd = 0;
        for(int i=0;i<n;i++)
        {
            int root = findPar(i);
            int num = target[i];

            HashMap<Integer,Integer> s = map.get(root);

            if(!s.containsKey(num))
            {
                hd++;
                continue;
            }
            if(s.get(num) <= 0)
            {
                hd++;
            }
            s.put(num,s.get(num)-1);
        }
        return hd;
    }
}
