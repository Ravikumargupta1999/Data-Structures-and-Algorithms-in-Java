import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            list.add(new ArrayList<>());
        int[] inDegree = new int[numCourses];
        for (int[] task : prerequisites) {
            list.get(task[1]).add(task[0]);
            inDegree[task[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            res[i++] = temp;
            for (int neighbour : list.get(temp)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }
        return i != numCourses  ? new int[]{}:res;
    }
}
