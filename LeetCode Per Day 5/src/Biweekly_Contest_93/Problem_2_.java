package Biweekly_Contest_93;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_2_ {
//    [1,-8,0]
//            [[1,0],[2,1]]
//            2
    public static void main(String[] args) {
        int[] vals = {-8};
        int[][] edges = {};
        int k = 2;
        System.out.println(maxStarSum(vals, edges, k));
    }

    public static int maxStarSum(int[] vals, int[][] edges, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = vals.length;
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int[] edge : edges) {
            list.get(edge[0]).add(vals[edge[1]]);
            list.get(edge[1]).add(vals[edge[0]]);
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> newArraylist = new ArrayList<>(list.get(i));
            Collections.sort(newArraylist);
            Collections.reverse(newArraylist);
            graph.add(newArraylist);
        }
        System.out.println(graph);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < graph.size(); i++) {

                int sum = vals[i];
                max = Math.max(max,sum);
                for (int j = 0; j < Math.min(k,graph.get(i).size()); j++) {
                    sum += graph.get(i).get(j);
                }
                System.out.println(sum);
                max = Math.max(max,sum);

        }
        return max;
    }
}
