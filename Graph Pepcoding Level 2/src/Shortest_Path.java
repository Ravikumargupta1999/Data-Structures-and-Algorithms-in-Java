import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Shortest_Path {
    static class Pair
    {
        int node;
        int weight;
        public Pair(int node,int weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }
    public static int shortestPath(ArrayList<ArrayList<Integer>> al ,int source,int target)
    {
        ArrayList<ArrayList<Pair>> array = new ArrayList<>();
        for(int i=0;i<al.size();i++)
        {
            array.add( new ArrayList<>());
        }

        for(int i=0;i<al.size();i++)
        {
            for(int j=0;j<al.get(i).size();j++)
            {
                int a = i;
                int b = al.get(i).get(j);
                Pair p1 = new Pair(b,0);
                array.get(i).add(p1);
                Pair p2 = new Pair(i,1);
                array.get(b).add(p2);
            }
        }
        System.out.println("\n\n");
        for (int i=0;i<array.size();i++)
        {
            System.out.print(i+" : ");
            for(int j=0;j<array.get(i).size();j++)
            {
                System.out.print("( "+array.get(i).get(j).node+" , "+ array.get(i).get(j).weight+" )  ");
            }
            System.out.println();
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            if(a.weight != b.weight)
                return a.weight- b.weight;
            else
                return a.node - b.node;

        });
        boolean[] visited = new boolean[al.size()];
        pq.add(new Pair(source,0));
        visited[source] = true;

        while (!pq.isEmpty())
        {
            Pair temp = pq.poll();
            if(temp.node == target) {
                System.out.println("\n\n");
                return temp.weight;
            }
            ArrayList<Pair> arrayList = array.get(temp.node);
            for(int j =0;j<arrayList.size();j++)
            {
                if(!visited[arrayList.get(j).node]) {
                    visited[arrayList.get(j).node] = true;
                    pq.add(new Pair(arrayList.get(j).node, arrayList.get(j).weight + temp.weight));
                }
            }
        }
        System.out.println("\n\n");
        return -1;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int n = 7;
        for(int i=0;i<n;i++)
        {
            al.add(new ArrayList<>());
        }
        int[][] arr = {{1},{},{1,3},{},{5},{1},{3,4}};
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<arr[i].length;j++)
            {
                temp.add(arr[i][j]);
            }
            al.set(i,temp);
        }
        System.out.println(al);
        System.out.println(shortestPath(al,0,6));
    }

}
