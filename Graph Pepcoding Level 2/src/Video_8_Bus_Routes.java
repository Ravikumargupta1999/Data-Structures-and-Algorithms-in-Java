//import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.*;

//https://leetcode.com/problems/bus-routes/
public class Video_8_Bus_Routes {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int busStopNo = routes[i][j];
                ArrayList<Integer> busNo = map.getOrDefault(busStopNo, new ArrayList<>());
                busNo.add(i);
                map.put(busStopNo, busNo);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> busStopVisited = new HashSet<>();
        HashSet<Integer> busVisited = new HashSet<>();

        queue.add(source);
        busStopVisited.add(source);

        int level = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int rem = queue.poll();
                if (rem == target)
                    return level;
                ArrayList<Integer> buses = map.get(rem);

                for (int bus : buses) {
                    if (busVisited.contains(bus))
                        continue;
                    int[] arr = routes[bus];
                    for (int busStop : arr) {
                        if (busStopVisited.contains(busStop))
                            continue;
                        queue.add(busStop);
                        busStopVisited.add(busStop);
                    }
                    busVisited.add(bus);
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        int source = 15, target = 12;
        System.out.println(numBusesToDestination(routes, source, target));
    }
}
