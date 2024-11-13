package Day_14_Stack_And_Queue_Part_II;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                else if (grid[i][j] == 1)
                    count++;
            }
        }
        if (count == 0)
            return 0;
        int level = -1;
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                int[] temp = queue.poll();
                visited[temp[0]][temp[1]] = true;
                int[][] arr = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int i = 0; i < 4; i++) {
                    int newRow = temp[0] + arr[i][0];
                    int newCol = temp[1] + arr[i][1];
                    if(newRow < 0 || newRow >= grid.length || newCol<0 || newCol>= grid[0].length)
                        continue;
                    if (grid[newRow][newCol] == 1 && !visited[newRow][newCol]){
                        grid[newRow][newCol] = 0;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
            level++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return level;
    }
}
