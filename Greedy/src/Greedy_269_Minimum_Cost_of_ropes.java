import java.util.PriorityQueue;

public class Greedy_269_Minimum_Cost_of_ropes {
    // https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
    long minCost(long arr[], int n)
    {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(long val : arr)
            queue.add(val);
        long ans = 0;
        while (queue.size() > 1)
        {
            long val = queue.poll() + queue.poll();
            ans += val;
            queue.add(val);
        }
        return ans;
    }
}
