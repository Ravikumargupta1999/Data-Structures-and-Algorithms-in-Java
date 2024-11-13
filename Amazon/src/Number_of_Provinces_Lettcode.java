import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/number-of-provinces/submissions/
public class Number_of_Provinces_Lettcode {
    int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int ans = 0;
        boolean[] visited = new boolean[v];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == true)
                continue;
            // System.out.println("For ");
            ans++;
            visited[i] = true;
            for (int j = 0; j < isConnected[i].length; j++) {
                if (j != i && isConnected[i][j] == 1)
                    bfs(j, isConnected, visited);
            }
        }
        return ans;
    }

    void bfs(int node, int[][] isConnected, boolean[] visited) {
//        System.out.println(Arrays.toString(visited));
        if (visited[node])
            return;
        visited[node] = true;
        for (int j = 0; j < isConnected[node].length; j++) {
            if (j != node && isConnected[node][j] == 1)
                bfs(j, isConnected, visited);
        }

    }
}
