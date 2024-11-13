import java.util.HashMap;
import java.util.Iterator;

public class P_1_Find_Center_of_Star_Graph {
    public static int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {

            int ele = iterator.next();
            if(map.get(ele) == edges.length)
                return ele;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(edges));
    }
}
