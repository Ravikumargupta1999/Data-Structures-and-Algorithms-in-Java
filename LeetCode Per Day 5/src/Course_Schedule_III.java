import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_III {
    public int scheduleCourse(int[][] courses) {
        int k = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < courses.length; i++) {
            if (map.containsKey(courses[i][0])) {
                courses[i][0] = map.get(courses[i][0]);
            } else {
                map.put(courses[i][0], k);
                courses[i][0] = k;
                k++;
            }

            if (map.containsKey(courses[i][1])) {
                courses[i][1] = map.get(courses[i][1]);
            } else {
                map.put(courses[i][1], k);
                courses[i][1] = k;
                k++;
            }
        }
        return findOrder(k,courses);
    }

    public int findOrder(int numCourses, int[][] prerequisites) {
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
        return i;
    }
}
