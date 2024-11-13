package Sumit_Malik_Level_2;

import java.util.ArrayList;

public class V_Video_26_Swap_Even_And_Odd_Bits {
    // https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits-1587115621/1/
    // https://www.youtube.com/watch?v=GbH8PcqKosk&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=26
    public static int swapBits(int n) {
        int om = 0x55555555;
        int em = 0xAAAAAAAA;
        int odd = (n & om);
        int even = (n & em);
        odd <<= 1;
        even >>= 1;
        n = odd | even;
        return n;
    }

    // https://practice.geeksforgeeks.org/problems/sum-of-dependencies-in-a-graph5311/1
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int val : adj.get(i)) {
                count++;
            }
        }
        return count;
    }
}
