import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1#
public class Video_62_Minimum_cost_to_connect_sticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.add(stick);
        }
        int cost = 0;
        while (queue.size() > 1) {
            int c1 = queue.poll();
            int c2 = queue.poll();
            int c = c1 + c2;
            cost += c;
            queue.add(c);
        }
        return cost;
    }
}
