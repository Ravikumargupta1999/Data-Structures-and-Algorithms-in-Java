import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/travelling-salesman-problem2732/1#
// https://www.youtube.com/watch?v=3QiSyc7KyC4
public class G_Graph_378_Travelling_Salesman_Problem {
    // Brute Force Accepted
    int min = Integer.MAX_VALUE;
    public  int total_cost(int[][] cost) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i < cost.length; i++) {
            set.add(i);
        }
        for (int i = 1; i < cost.length; i++) {
            findMinimumCost(i, cost, cost[0][i], set);
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }

    public  void findMinimumCost(int i, int[][] matrix, int cost, HashSet<Integer> set) {
        if (set.size() == 1) {
            min = Math.min(min, matrix[i][0] + cost);
            return;
        }
        set.remove(i);
        HashSet<Integer> cloned_set = new HashSet<>();
        cloned_set = (HashSet) set.clone();
        for (int key : cloned_set) {
            findMinimumCost(key, matrix, cost + matrix[i][key], set);
        }
        set.add(i);
    }


}
